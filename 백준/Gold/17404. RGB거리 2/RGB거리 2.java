import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int min = 1000 * 1000;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix;
    static int[][] dp;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[0][i] = matrix[0][i];
                } else {
                    dp[0][i] = 1000 * 1000;
                }
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + matrix[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + matrix[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    min = Math.min(min, dp[N-1][i]);
                }
            }
        }

        System.out.println(min);
    }
}