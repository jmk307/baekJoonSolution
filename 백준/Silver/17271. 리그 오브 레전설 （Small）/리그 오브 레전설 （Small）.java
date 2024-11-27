import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	static int[] matrix;
	static long[] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new long[100002];
		dp[0] = 1;
		
		for (int i = 1; i < M; i++) {
		    dp[i] = 1;
		}
        
		for (int i = M; i <= N; i++) {
		    dp[i] = (dp[i-1] % 1000000007 + dp[i-M] % 1000000007) % 1000000007;
		}
		
		System.out.println(dp[N] % 1000000007);
	}
}
