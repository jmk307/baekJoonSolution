import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    static int n;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[50001];
        for (int i = 1; i < 50001; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < 50001; i++) {
            int current = (int) Math.sqrt(i);
            for (int j = 1; j <= current; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}