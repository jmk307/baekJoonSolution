import java.util.*;
import java.io.*;

public class Main {
    static int N, A, B, C, D;
    
    static int[] parent;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        long max = N * (N-1) / 2;
        sb.append(max).append("\n");
        
        long gap = 2;
        long current = 1;
        for (int i = 0; i < N; i++) {
            sb.append(current).append(" ");
            
            current *= gap;
        }
        sb.append("\n");
        
        long min = N - 1;
        sb.append(min).append("\n");
        
        gap = 2;
        current = 1;
        for (int i = 0; i < N; i++) {
            sb.append(current).append(" ");
            
            current += gap;
        }
        
        System.out.println(sb);
    }
}
