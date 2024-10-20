import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            list[A].add(new Node(B, weight));
            list[B].add(new Node(A, weight));
        }
        
        System.out.println(dijkstra(1));
    }
    
    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.target;
            
            if (!visited[now]) {
                visited[now] = true;
                
                for (Node n : list[now]) {
                    if (!visited[n.target] && dist[n.target] > dist[now] + n.value) {
                        dist[n.target] = dist[now] + n.value;
                        pq.add(new Node(n.target, dist[n.target]));
                    }
                }
            }
            
        }
        
        return dist[N];
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
