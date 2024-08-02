import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int[] matrix;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        matrix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(matrix[1]);
            return;
        }

        dp[1][0] = matrix[1];
        dp[1][1] = matrix[1];
        dp[1][2] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2])) + matrix[i];
            dp[i][1] = dp[i - 1][0] + matrix[i];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        }

        int max = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        System.out.println(max);
    }
}