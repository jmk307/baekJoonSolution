import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int answer = -1;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] dp, trace;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        trace = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            trace[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                trace[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                trace[i] = i / 3;
            }
        }

        sb.append(dp[N]).append("\n");
        while (N > 0) {
            sb.append(N).append(" ");
            N = trace[N];
        }

        System.out.println(sb);
    }
}