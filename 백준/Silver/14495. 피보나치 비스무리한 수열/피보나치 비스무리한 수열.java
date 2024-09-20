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

        dp = new long[117];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 3];
        }

        System.out.println(dp[n]);
    }
}