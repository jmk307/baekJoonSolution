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
        
        int sum = 0;
        st = new StringTokenizer(br.readLine());
            
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        sum += A;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            
            int gap = 0;
            if (sum % (C + D) < C) {
                gap += 0;
            } else {
                int term = (C + D) - (sum % (C + D));
                
                gap += term;
            }
            
            sum += Math.min(B, A + gap);
        }
        
        System.out.println(sum);
    }
}
