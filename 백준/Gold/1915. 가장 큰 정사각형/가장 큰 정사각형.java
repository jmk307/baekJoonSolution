import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	
	static int[][] matrix, dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		
		for (int i = 1; i < n + 1; i++) {
		    String[] arrays = br.readLine().split("");
		    for (int j = 1; j < m + 1; j++) {
		        int now = Integer.parseInt(arrays[j-1]);
		        matrix[i][j] = now;
		        dp[i][j] = now;
		    }
		}
		
		long max = 0;
		for (int i = 1; i < n + 1; i++) {
		    for (int j = 1; j < m + 1; j++) {
		        if (matrix[i-1][j] == 1 && matrix[i][j-1] == 1 && matrix[i-1][j-1] == 1 && matrix[i][j] == 1) {
		            dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
		        }
		        max = Math.max(max, dp[i][j]);
		    }
		}
		
		System.out.println(max * max);
	}
}
