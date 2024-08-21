import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static ArrayList<Integer>[] matrix;
    
    static boolean[] visited;
    
    static Integer[] answer;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        matrix = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new Integer[M];
        
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (j != i) {
                    matrix[i].add(j);
                }
            }
        }
        
        for (int i = 1; i < N + 1; i++) {
            DFS(i, 0);
        }
        
        System.out.println(sb);
    }
    
    static void DFS(int v, int depth) {
        answer[depth] = v;
        visited[v] = true;
        
        if (depth == M - 1) {
            Set<Integer> set = new HashSet<>(Arrays.asList(answer));
            
            if (set.size() == M) {
                for (int i : answer) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
            
            return;
        }
        
        for (int i = 0; i < matrix[v].size(); i++) {
            DFS(matrix[v].get(i), depth + 1);
        }
    }
}