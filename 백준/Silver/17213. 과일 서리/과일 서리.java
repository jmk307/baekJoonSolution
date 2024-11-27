import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] dp;
    static int[] result;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[M + 1][M + 1];

        System.out.println(comb(M, N));
    }

    static int comb(int n, int r) {
        if (r == 1 || n == r) {
            return 1;
        } else if (dp[n][r] != 0) {
            return dp[n][r];
        }

        return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}