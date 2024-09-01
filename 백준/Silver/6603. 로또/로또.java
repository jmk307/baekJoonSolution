import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int k;
    
    static int[] matrix;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String input = "";
        while ((input = br.readLine()) != "0") {
            st = new StringTokenizer(input);
            
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            
            matrix = new int[k + 1];
            result = new int[k + 1];
            visited = new boolean[k + 1];
            
            for (int i = 1; i < k + 1; i++) {
                matrix[i] = Integer.parseInt(st.nextToken());
            }
            
            DFS(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void DFS(int depth, int prev) {
        if (depth == 6) {
            for (int i = 1; i < depth + 1; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            
            return;
        }
        
        for (int i = 1; i < k + 1; i++) {
            if (!visited[i] && prev < matrix[i]) {
                visited[i] = true;
                result[depth + 1] = matrix[i];
                DFS(depth + 1, matrix[i]);
                
                visited[i] = false;
            }
        }
    }
}