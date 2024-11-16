import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b, K;
    static long result = Long.MAX_VALUE;
    
    static int[][] matrix;
    static int[][] dp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N + 1][2];
        dp = new int[N + 1][2];
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            matrix[i][0] = a;
            matrix[i][1] = b;
        }
        
        K = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            dp[1][0] = dp[1][1] = 0;
        } else if (N == 2) {
            dp[1][0] = dp[1][1] = 0;
            dp[2][0] = dp[2][1] = matrix[1][0];
        } else if (N == 3) {
            dp[1][0] = dp[1][1] = 0;
            dp[2][0] = dp[2][1] = matrix[1][0];
            dp[3][0] = dp[3][1] = Math.min(dp[1][0] + matrix[1][1], dp[2][0] + matrix[2][0]);
        } else {
            dp[1][0] = dp[1][1] = 0;
            dp[2][0] = dp[2][1] = matrix[1][0];
            dp[3][0] = dp[3][1] = Math.min(dp[1][0] + matrix[1][1], dp[2][0] + matrix[2][0]);
            
            for (int i = 4; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][0] + matrix[i-1][0], dp[i-2][0] + matrix[i-2][1]);
                dp[i][1] = Math.min(dp[i-3][0] + K, Math.min(dp[i-1][1] + matrix[i-1][0], dp[i-2][1] + matrix[i-2][1]));
            }
        }
        
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
