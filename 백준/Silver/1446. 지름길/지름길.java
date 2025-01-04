import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, D;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static int[][] matrix;
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        matrix = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            matrix[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }
        
        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
            for (int j = 0; j < N; j++) {
                if (matrix[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[matrix[j][0]] + matrix[j][2]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}