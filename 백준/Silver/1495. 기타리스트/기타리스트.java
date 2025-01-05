import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, S, M;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] dp;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        dp[0][S] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= M; j++) {
                if (dp[i-1][j] != 0) {
                    if (j - now >= 0) {
                        dp[i][j - now] = 1;
                    }

                    if (j + now <= M) {
                        dp[i][j + now] = 1;
                    }
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i] != 0) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}