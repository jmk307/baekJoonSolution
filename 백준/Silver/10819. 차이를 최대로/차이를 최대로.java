import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    static int max = 0;
    
    static int[] matrix;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        DFS(0);
        
        System.out.println(max);
    }
    
    static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;
            
            for (int i = 1; i < depth; i++) {
                sum += (int) Math.abs(result[i] - result[i + 1]);
            }
            
            max = Math.max(max, sum);
            
            return;
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth + 1] = matrix[i];
                DFS(depth + 1);
                
                visited[i] = false;
            }
        }
    }
}