import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N;
    
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            N = Integer.parseInt(br.readLine());
            
            matrix = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++) {
                matrix[i] = new ArrayList<>();
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                int current = Integer.parseInt(st.nextToken());
                matrix[i].add(current);
            }
            
            int count = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    count++;
                    DFS(i);
                }
            }
            
            System.out.println(count);
        }
    }
    
    static void DFS(int v) {
        visited[v] = true;
        
        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}