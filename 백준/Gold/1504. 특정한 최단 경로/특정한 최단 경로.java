import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, E, a, b, c, v1, v2;
    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 200000000;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        int a = dijkstra(1, v1);
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        int b = dijkstra(1, v2);
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        int c = dijkstra(v1, v2);
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        int d = dijkstra(v2, N);
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        int e = dijkstra(v1, N);
        
        long case1 = a + c + d;
        long case2 = b + c + e;
        
        long result = Math.min(case1, case2);
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
    
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.target;
            
            for (Node n : list[now]) {
                if (dist[n.target] > dist[now] + n.value) {
                    dist[n.target] = dist[now] + n.value;
                    pq.add(new Node(n.target, dist[n.target]));
                }
            }
        }
        
        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int target;
    
    int value;
    
    public Node(int target, int value) {
        this.target = target;
        this.value = value;
    }
    
    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}