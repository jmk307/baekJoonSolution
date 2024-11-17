import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int max = 0;
	static int min = Integer.MAX_VALUE;

	static int[][] matrix;
	static int[][][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][3];
		dp = new int[N][3][2];
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 3; j++) {
		        matrix[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		for (int i = 0; i < 3; i++) {
		    dp[0][i][0] = matrix[0][i];
		    dp[0][i][1] = matrix[0][i];
		}
		
		for (int i = 1; i < N; i++) {
		    dp[i][0][0] = Math.max(matrix[i][0] + dp[i-1][0][0], matrix[i][0] + dp[i-1][1][0]);
		    dp[i][1][0] = Math.max(matrix[i][1] + dp[i-1][0][0], Math.max(matrix[i][1] + dp[i-1][1][0], matrix[i][1] + dp[i-1][2][0]));
		    dp[i][2][0] = Math.max(matrix[i][2] + dp[i-1][1][0], matrix[i][2] + dp[i-1][2][0]);
		    
		    dp[i][0][1] = Math.min(matrix[i][0] + dp[i-1][0][1], matrix[i][0] + dp[i-1][1][1]);
		    dp[i][1][1] = Math.min(matrix[i][1] + dp[i-1][0][1], Math.min(matrix[i][1] + dp[i-1][1][1], matrix[i][1] + dp[i-1][2][1]));
		    dp[i][2][1] = Math.min(matrix[i][2] + dp[i-1][1][1], matrix[i][2] + dp[i-1][2][1]);
		}
		
		for (int i = 0; i < 3; i++) {
		    max = Math.max(max, dp[N-1][i][0]);
		    min = Math.min(min, dp[N-1][i][1]);
		}
		
		System.out.print(max);
		System.out.print(" ");
		System.out.print(min);
	}
}
