import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M, x, y, u, v;
    
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    
    static int[] matrix = new int[101];
    static boolean[] visited = new boolean[101];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            ladder.put(x, y);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            
            snake.put(u, v);
        }
        
        BFS(new Node(1, 0));
    }
    
    static void BFS(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.current] = true;
        
        while (!que.isEmpty()) {
            Node now = que.poll();
            
            if (ladder.containsValue(now.current)) {
                visited[now.current] = true;
            }
            
            if (snake.containsValue(now.current)) {
                visited[now.current] = true;
            }
            
            if (now.current == 100) {
                System.out.println(now.count);
                break;
            }
            
            for (int i = 1; i <= 6; i++) {
                if (now.current + i <= 100) {
                    if (!visited[now.current + i]) {
                        visited[now.current + i] = true;
                        
                        if (ladder.containsKey(now.current + i)) {
                            que.add(new Node(ladder.get(now.current + i), now.count + 1));
                        } else if (snake.containsKey(now.current + i)) {
                            que.add(new Node(snake.get(now.current + i), now.count + 1));
                        } else {
                            que.add(new Node(now.current + i, now.count + 1));
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int current;
    int count;
    
    public Node(int current, int count) {
        this.current = current;
        this.count = count;
    }
}