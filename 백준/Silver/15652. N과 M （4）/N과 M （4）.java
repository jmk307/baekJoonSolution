import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        matrix = new int[N + 1];
        visited = new boolean[N + 1];
        
        DFS(0, 0);
        
        System.out.println(sb);
    }
    
    static void DFS(int depth, int prev) {
        if (depth == M) {
            for (int i = 1; i < depth + 1; i++) {
                sb.append(matrix[i]).append(" ");
            }
            sb.append("\n");
            
            return;
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (prev <= i) {
                visited[i] = true;
                matrix[depth + 1] = i;
                DFS(depth + 1, i);
                
                visited[i] = false;
            }
        }
    }
}