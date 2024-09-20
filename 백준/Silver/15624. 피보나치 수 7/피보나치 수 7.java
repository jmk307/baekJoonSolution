import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n;

    static long[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        
        if (n == 0) {
            dp[0] = 0;
        } else if (n == 1) {
            dp[0] = 0;
            dp[1] = 1;
        } else {
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i -1] % 1000000007 + dp[i - 2] % 1000000007;
            }
        }

        System.out.println(dp[n] % 1000000007);
    }
}