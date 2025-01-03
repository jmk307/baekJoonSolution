import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static long[] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		dp = new long[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < n; i++) {
		    int current = Integer.parseInt(br.readLine());
		    
		    matrix[i] = current;
		    if (current <= k) {
		        dp[current] = 1;
		    }
		}
		Arrays.sort(matrix);
		
		for (int i = 1; i <= k; i++) {
		    for (int j : matrix) {
	            if (i >= j && i-j <= k) {
	                dp[i] = Math.min(dp[i], dp[i-j] + 1);
	            }
	        }
		}
		
		if (dp[k] == Integer.MAX_VALUE) {
		    System.out.println(-1);
		} else {
		    System.out.println(dp[k]);
		}
	}
}
