import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b;
    
    static boolean[] visited = new boolean[360];
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            int start = (a + 180 - b) % 360;
            int end = (a + 180 + b) % 360;
            
            if (start <= end) {
                for (int i = start; i <= end; i++) {
                    visited[i] = true;
                }
            } else {
                for (int i = start; i < 360; i++) {
                    visited[i] = true;
                }
                for (int i = 0; i <= end; i++) {
                    visited[i] = true;
                }
            }
            
            if (b == 180) {
                visited[(a + 180) % 360] = true;
            }
        }
        
        int count = 0;
        for (int i = 0; i <= 359; i++) {
            if (visited[i]) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
