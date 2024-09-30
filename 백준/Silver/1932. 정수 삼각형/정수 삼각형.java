import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        matrix = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j][i] = matrix[0][i] + dp[0][i-1];
                } else if (j == i) {
                    dp[j][i] = matrix[i][i] + dp[i-1][i-1];
                } else {
                    dp[j][i] = Math.max(matrix[j][i] + dp[j-1][i-1], matrix[j][i] + dp[j][i-1]);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i][n-1], max);
        }
        
        System.out.println(max);
    }
}
