import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int R, C, Q, r1, c1, r2, c2;

    static int[][] matrix, dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        matrix = new int[R + 1][C + 1];
        dp = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            int total = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            int count = (c2 - c1 + 1) * (r2 - r1 + 1);

            System.out.println(total / count);
        }
    }
}