import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String input;

	static int[][] matrix;
	static int[][][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];
		
		for (int i = 1; i < N + 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j < N + 1; j++) {
		        matrix[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		dp[1][2][0] = 1;
		for (int j = 3; j < N + 1; j++) {
		    if (matrix[1][j] == 0) {
	            dp[1][j][0] = dp[1][j-1][0] + dp[1][j-1][2];
	        }
	        
	        if (matrix[1][j] == 0) {
	            dp[1][j][1] = dp[0][j][1] + dp[0][j][2];
	        }
	        
	        if (matrix[1][j] == 0 && matrix[0][j] == 0 && matrix[1][j-1] == 0) {
	            dp[1][j][2] = dp[0][j-1][0] + dp[0][j-1][1] + dp[0][j-1][2];
	        }
		}
		
		for (int i = 2; i < N + 1; i++) {
		    for (int j = 1; j < N + 1; j++) {
		        if (matrix[i][j] == 0) {
		            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
		        }
		        
		        if (matrix[i][j] == 0) {
		            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
		        }
		        
		        if (matrix[i][j] == 0 && matrix[i-1][j] == 0 && matrix[i][j-1] == 0) {
		            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
		        }
		    }
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}
