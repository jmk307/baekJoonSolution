import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix, dp;
    static boolean[][] visited;
    static int[][] dist;
    static ArrayList<Integer>[] list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[1] = 2;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] * 2 + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}