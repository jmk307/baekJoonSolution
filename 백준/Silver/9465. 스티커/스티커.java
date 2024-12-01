import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int T, n;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static int[][] dp;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            matrix = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = matrix[0][1];
            dp[1][1] = matrix[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(matrix[0][j] + dp[1][j-1],
                        Math.max(matrix[0][j] + dp[0][j-2], matrix[0][j] + dp[1][j-2]));
                dp[1][j] = Math.max(matrix[1][j] + dp[0][j-1],
                        Math.max(matrix[1][j] + dp[0][j-2], matrix[1][j] + dp[1][j-2]));
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}