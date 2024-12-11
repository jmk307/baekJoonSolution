import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static boolean isAnswer = false; 
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] matrix;
	static boolean[][] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		matrix = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
		    String[] arrays = br.readLine().split("");
		    for (int j = 0; j < N; j++) {
		        matrix[i][j] = Integer.parseInt(arrays[j]);
		    }
		}
		
		for (int i = 0; i < N; i++) {
		    if (!visited[0][i]) {
	            DFS(0, i);
	        }
		}
		
		if (isAnswer) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}
	}
	
	static void DFS(int a, int b) {
	    visited[a][b] = true;
	    if (a == M - 1) {
	        isAnswer = true;
	        return;
	    }
	    
	    for (int i = 0; i < 4; i++) {
	        int x = a + dx[i];
	        int y = b + dy[i];
	        
	        if (x >= 0 && y >= 0 && x < M && y < N) {
	            if (!visited[x][y] && matrix[x][y] == 0) {
	                DFS(x, y);
	            }
	        }
	    }
	}
}
