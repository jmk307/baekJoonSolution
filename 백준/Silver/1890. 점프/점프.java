import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static long[][] dp;
    static int[][] matrix;
    static boolean[][][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (matrix[0][0] < N) {
            dp[0][matrix[0][0]]++;
            dp[matrix[0][0]][0]++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == N-1 && j == N-1) {
                    continue;
                }

                if (dp[i][j] != 0 && i + matrix[i][j] < N) {
                    dp[i + matrix[i][j]][j] += dp[i][j];
                }

                if (dp[i][j] != 0 && j + matrix[i][j] < N) {
                    dp[i][j + matrix[i][j]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}