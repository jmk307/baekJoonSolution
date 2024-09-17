import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, A, B;
    
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            visited = new boolean[10000];
            BFS(new Node(A, ""));
        }
        
        System.out.println(sb);
    }
    
    static void BFS(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.current] = true;
        
        while (!que.isEmpty()) {
            Node now = que.poll();
            
            int nowCurrent = now.current;
            String nowOrder = now.order;
            
            if (nowCurrent == B) {
                sb.append(nowOrder).append("\n");
                
                return;
            }
            
            int nowD = (2 * nowCurrent) % 10000;
            if (!visited[nowD]) {
                visited[nowD] = true;
                que.add(new Node(nowD, nowOrder + "D")); 
            }
            
            int nowS = 0;
            if (nowCurrent == 0) {
                nowS = 9999;
            } else {
                nowS = nowCurrent - 1;
            }
            
            if (!visited[nowS]) {
                visited[nowS] = true;
                que.add(new Node(nowS, nowOrder + "S"));
            }
            
            String stringL = String.valueOf(nowCurrent);
            int nowL = 0;
            if (stringL.length() != 4) {
                nowL = nowCurrent * 10;
            } else {
                nowL = nowCurrent % 1000 * 10 + Integer.parseInt(String.valueOf(stringL.charAt(0))); 
            }
            
            if (!visited[nowL]) {
                visited[nowL] = true;
                que.add(new Node(nowL, nowOrder + "L"));
            }
            
            String stringR = String.valueOf(nowCurrent);
            int last = Integer.parseInt(String.valueOf(stringR.charAt(stringR.length() - 1)));
            int nowR = last * 1000 + (nowCurrent - last) / 10;
            
            if (!visited[nowR]) {
                visited[nowR] = true;
                que.add(new Node(nowR, nowOrder + "R"));
            }
        }
    }
}

class Node {
    int current;
    
    String order;
    
    public Node(int current, String order) {
        this.current = current;
        this.order = order;
    }
}