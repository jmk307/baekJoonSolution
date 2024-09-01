import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}