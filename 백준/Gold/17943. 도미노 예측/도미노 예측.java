import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, Q, x, d, y;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix, dp;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        matrix = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            dp[i] = matrix[i] ^ dp[i-1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int now = Integer.parseInt(st.nextToken());

            if (now == 0) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                System.out.println(dp[y-1] ^ dp[x-1]);
            } else {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                System.out.println(dp[y-1] ^ dp[x-1] ^ d);
            }
        }
    }
}