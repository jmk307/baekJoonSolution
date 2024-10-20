import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K, u, v, w;
    
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Node>();
        }
        
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        visited = new boolean[V + 1];
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            list[u].add(new Node(v, w));
        }
        
        for (int i = 1; i <= V; i++) {
            int result = dijkstra(K, i);
            
            if (result == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result);
            }
        }
    }
    
    static int dijkstra(int start, int end) {
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
