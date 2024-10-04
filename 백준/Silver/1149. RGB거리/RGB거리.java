import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, R, G, B;

    static int[][] matrix;
    static int[][] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[3][N];
        dp = new int[3][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            matrix[0][i] = R;
            matrix[1][i] = G;
            matrix[2][i] = B;
        }

        dp[0][0] = matrix[0][0];
        dp[1][0] = matrix[1][0];
        dp[2][0] = matrix[2][0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.min(dp[2][i-1] + matrix[0][i], dp[1][i-1] + matrix[0][i]);

            dp[1][i] = Math.min(dp[2][i-1] + matrix[1][i], dp[0][i-1] + matrix[1][i]);

            dp[2][i] = Math.min(dp[1][i-1] + matrix[2][i], dp[0][i-1] + matrix[2][i]);
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            min = Math.min(min, dp[j][N-1]);
        }

        System.out.println(min);
    }
}