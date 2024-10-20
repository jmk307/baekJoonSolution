import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, u, v;
    
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] visited;
    static int count = 1;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        answer = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            
            list[u].add(v);
            list[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        
        DFS(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
    
    static void DFS(int r) {
        visited[r] = true;
        answer[r] = count;
        count++;
        
        for (int i : list[r]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
