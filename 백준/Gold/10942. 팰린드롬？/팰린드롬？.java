import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, S, E;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[] matrix;
    static boolean[][] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i <= N - 1; i++) {
            if (matrix[i] == matrix[i + 1]) {
                dp[i][i + 1]= true;
            }
        }

        for (int i = 2; i < N; i++){
            for (int j = 1; j <= N - i; j++){
                if (matrix[j] == matrix[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if (dp[S][E]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}