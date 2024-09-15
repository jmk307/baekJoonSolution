import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;
    
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[100001];
        
        BFS(new Node(N, 0));
    }
    
    static void BFS(Node node) {
        if (node.current <= 100000) {
           visited[node.current] = true; 
        }
        
        if (node.current == K) {
            System.out.println(node.depth);
            return;
        }
        
        Queue<Node> que = new LinkedList<>();
        
        if (2 * node.current <= 100000) {
            que.add(new Node(2 * node.current, node.depth));
        }
        
        if (node.current - 1 >= 0) {
            que.add(new Node(node.current - 1, node.depth + 1));
        }
        
        if (node.current + 1 <= 100000) {
            que.add(new Node(node.current + 1, node.depth + 1));
        }
        
        while (!que.isEmpty()) {
            Node now = que.poll();
            
            if (now.current <= 100000) {
               visited[now.current] = true; 
            }
            
            if (now.current == K) {
                System.out.println(now.depth);
                return;
            }
            
            if (2 * now.current <= 100000) {
                que.add(new Node(2 * now.current, now.depth));
            }
            
            if (now.current - 1 >= 0 && !visited[now.current - 1]) {
                que.add(new Node(now.current - 1, now.depth + 1));
            }
            
            if (now.current + 1 <= 100000 && !visited[now.current + 1]) {
                que.add(new Node(now.current + 1, now.depth + 1));
            }
        }
    }
}

class Node {
    int current;
    
    int depth;
    
    public Node(int current, int depth) {
        this.current = current;
        this.depth = depth;
    }
}