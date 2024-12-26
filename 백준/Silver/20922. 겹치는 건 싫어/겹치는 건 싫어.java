import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int max = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static int[] visited = new int[100001];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		visited[matrix[0]]++;
		
		while (true) {
		    max = Math.max(max, end - start + 1);
		    if (end == N - 1) {
		        break;
		    }
		    
		    end++;
		    visited[matrix[end]]++;
		    if (visited[matrix[end]] > K) {
		        while (visited[matrix[end]] != K) {
		            visited[matrix[start]]--;
		            start++;
		        }
		    }
		}
		
		System.out.println(max);
	}
}
