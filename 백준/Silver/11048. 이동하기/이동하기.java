import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int max = 0;
    
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    
    static int[][] matrix;
    static int[][] dp;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];
		
		for (int i = 1; i < N + 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j < M + 1; j++) {
		        matrix[j][i] = Integer.parseInt(st.nextToken());
		    }
		}
		
		for (int i = 1; i < N + 1; i++) {
		    for (int j = 1; j < M + 1; j++) {
		        dp[j][i] = Math.max(dp[j-1][i], Math.max(dp[j][i-1], dp[j-1][i-1])) + matrix[j][i];
		    }
		}
		
		System.out.println(dp[M][N]);
	}
}