import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    
    static ArrayList<Integer>[] matrix = new ArrayList[26];
    static boolean[] visited;
    static boolean isAnswer = false;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 26; i++) {
            matrix[i] = new ArrayList<>();
        }
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            
            int x = input[0].charAt(0) - 'a';
            int y = input[2].charAt(0) - 'a';
            
            matrix[x].add(y);
        }
        
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            
            int x = input[0].charAt(0) - 'a';
            int y = input[2].charAt(0) - 'a';
            
            visited = new boolean[26];
            isAnswer = false;
            
            DFS(x, y);
            
            if (isAnswer) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }
    
    static void DFS(int v, int y) {
        visited[v] = true;
        if (v == y) {
            isAnswer = true;
        }
        
        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i, y);
            }
        }
    }
}
