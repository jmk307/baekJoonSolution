import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, W;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[] matrix;
    static int[][][] dp;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        matrix = new int[T + 1];
        dp = new int[T + 1][3][W + 1];

        for (int i = 1; i < T + 1; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        if (matrix[1] == 1) {
            dp[1][1][0] = 1;
        } else if (matrix[1] == 2) {
            dp[1][2][1] = 1;
        }

        for (int i = 2; i < T + 1; i++) {
            if (matrix[i] == 1) {
                dp[i][1][0] = dp[i-1][1][0] + 1;
                dp[i][2][0] = dp[i-1][2][0];

                for (int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]) + 1;
                    dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]);
                }
            } else {
                dp[i][1][0] = dp[i-1][1][0];
                dp[i][2][0] = dp[i-1][2][0] + 1;

                for (int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]);
                    dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(answer, dp[T][1][i]);
            answer = Math.max(answer, dp[T][2][i]);
        }

        System.out.println(answer);
    }
}