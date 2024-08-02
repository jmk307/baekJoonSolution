import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix;
    static int[][] dp;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1];
		dp = new int[N + 1][2];
		for (int i = 1; i < N + 1; i++) {
		    matrix[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0]= matrix[1];
	    dp[1][1] = matrix[1];
		if (N == 1) {
		    System.out.println(matrix[1]);
		} else if (N == 2) {
		    dp[2][0] = matrix[2];
    		dp[2][1] = matrix[1] + matrix[2];
    		
    		System.out.println(Math.max(dp[2][0], dp[2][1]));
		} else {
    		dp[2][0] = matrix[2];
    		dp[2][1] = matrix[1] + matrix[2];
    		
    		for (int i = 3; i < N + 1; i++) {
    		    dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + matrix[i];
    	        dp[i][1] = dp[i-1][0] + matrix[i];
    		}
    		
    		System.out.println(Math.max(dp[N][0], dp[N][1]));
		}
	}
}
