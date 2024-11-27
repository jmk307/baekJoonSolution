import java.util.*;
import java.io.*;

public class Main {
	static int N;

	static int[] matrix;
	static int[] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
		    dp[i] = matrix[i];
		    
		    for (int j = 0; j < i; j++) {
		        if (matrix[j] > matrix[i]) {
		            dp[i] = Math.max(dp[i], dp[j] + matrix[i]);
		        }
		    }
		    
		    max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
