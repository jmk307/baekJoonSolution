import java.util.*;
import java.io.*;

public class Main {
    static int N, M, a, b;
    
    static long[] matrix;
    static long[][] dp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        matrix = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            if (b == 0) {
                matrix[i] = 1;
            } else {
                matrix[i] = M - 1;
            }
        }
        
        dp = new long[N + 1][2];
        dp[1][0] = matrix[1];
        if (matrix[1] == 1) {
            dp[1][1] = M - 1;
        } else {
            dp[1][1] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] * matrix[i]) % 1000000007;
            
            if (matrix[i] == 1) {
                dp[i][1] = ((dp[i-1][1] * matrix[i]) % 1000000007 + (dp[i-1][0] * (M-1)) % 1000000007) % 1000000007;
            } else {
                dp[i][1] = ((dp[i-1][1] * matrix[i]) % 1000000007 + (dp[i-1][0]) % 1000000007) % 1000000007;
            }
        }
        
        System.out.println((dp[N][0] + dp[N][1]) % 1000000007);
    }
}
