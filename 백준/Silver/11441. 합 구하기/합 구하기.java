import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M, i, j;

    static int[] matrix;
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = matrix[1];
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i-1] + matrix[i];
        }

        M = Integer.parseInt(br.readLine());

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j] - dp[i-1]);
        }
    }
}