import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int D, K;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] dp;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[D + 1][2];
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[2][0] = 0;
		dp[2][1] = 1;
		
		for (int i = 3; i <= D; i++) {
		    dp[i][0] = dp[i-1][0] + dp[i-2][0];
		    dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		int a = 0;
		int b = 0;
		while (true) {
		    a++;
		    
		    if ((K - a * dp[D][0]) % dp[D][1] == 0) {
		        b = (K - a * dp[D][0]) / dp[D][1];
		        break;
		    }
		}
		
		System.out.println(a);
		System.out.println(b);
	}
}
