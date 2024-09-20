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

        dp[0] = 1L;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}