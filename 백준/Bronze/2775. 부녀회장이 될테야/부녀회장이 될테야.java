import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int T, k, n;

    static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        for (int i = 0; i < 15; i++) {
            dp[i][1] = 1;
            dp[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }

        System.out.print(sb);
    }
}