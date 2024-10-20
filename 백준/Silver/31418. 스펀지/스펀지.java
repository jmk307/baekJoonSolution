import java.util.*;
import java.io.*;

public class Main {
    static int W, H, K, T, x, y;
    
    static int[] parent;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        long answer = 1;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            long a = x - T;
            if (a < 1) {
                a = 1;
            }
            
            long b = x + T;
            if (b > W) {
                b = W;
            }
            
            long c = y - T;
            if (c < 1) {
                c = 1;
            }
            
            long d = y + T;
            if (d > H) {
                d = H;
            }
            
            long wid = (b - a + 1);
            long height = (d - c + 1);
            
            answer = (answer * wid % 998244353) * height % 998244353;
        }
        
        System.out.println(answer);
    }
}
