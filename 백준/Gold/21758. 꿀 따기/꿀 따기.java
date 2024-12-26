import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long max = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static long[] matrix, dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new long[N];
		dp = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    matrix[i] = Long.parseLong(st.nextToken());
		}
		
		dp[0] = matrix[0];
		for (int i = 1; i < N; i++) {
		    dp[i] = dp[i-1] + matrix[i];
		}
		
		for (int i = 1; i <= N-2; i++) {
		    long a = dp[N-1] - dp[0] - matrix[i] + dp[N-1] - dp[i];
		    max = Math.max(max, a);
		    
		    long b = dp[i] - dp[0] + dp[N-1] - dp[i-1] - matrix[N-1];
		    max = Math.max(max, b);
		    
		    long c = dp[N-1] - matrix[i] - matrix[N-1] + dp[N-1] - (dp[N-1] - dp[i]) - matrix[i];
		    max = Math.max(max, c);
		}
		
		System.out.println(max);
	}
}
