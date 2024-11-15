import java.util.*;
import java.io.*;

public class Main {
    static int D;
    
    static long[][] dp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        D = Integer.parseInt(br.readLine());
        dp = new long[D + 1][9];
        dp[0][1] = 1;
        
        for (int i = 0; i < D; i++) {
            dp[i + 1][1] = (dp[i][2] + dp[i][3]) % 1000000007;
            dp[i + 1][2] = (dp[i][1] + dp[i][3] + dp[i][4]) % 1000000007;
            dp[i + 1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % 1000000007;
            dp[i + 1][4] = (dp[i][2] + dp[i][3] + dp[i][5] + dp[i][6]) % 1000000007;
            dp[i + 1][5] = (dp[i][3] + dp[i][4] + dp[i][6] + dp[i][7]) % 1000000007;
            dp[i + 1][6] = (dp[i][4] + dp[i][5] + dp[i][8]) % 1000000007;
            dp[i + 1][7] = (dp[i][5] + dp[i][8]) % 1000000007;
            dp[i + 1][8] = (dp[i][6] + dp[i][7]) % 1000000007;
        }
        
        System.out.println(dp[D][1]);
    }
}
