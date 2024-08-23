import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N, M;

    static int[][] dp = new int[30][30];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int result = comb(M, N);

            System.out.println(result);
        }
    }

    static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}