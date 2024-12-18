import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, K;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static long[][] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[K + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] % 1000000000 + dp[i][j-1] % 1000000000) % 1000000000;
            }
        }

        System.out.println(dp[K][N] % 1000000000);
    }
}