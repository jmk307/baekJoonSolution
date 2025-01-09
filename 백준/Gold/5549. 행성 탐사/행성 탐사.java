import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] matrix, a, b, c;
	static boolean[][][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		K = Integer.parseInt(br.readLine());
		
		matrix = new int[M + 1][N + 1];
		a = new int[M + 1][N + 1];
		b = new int[M + 1][N + 1];
		c = new int[M + 1][N + 1];
		
		for (int i = 1; i < M + 1; i++) {
		    String[] arrays = br.readLine().split("");
		    for (int j = 1; j < N + 1; j++) {
		        if (arrays[j-1].equals("J")) {
		            matrix[i][j] = 1;
		        } else if (arrays[j-1].equals("I")) {
		            matrix[i][j] = 2;
		        } else {
		            matrix[i][j] = 3;
		        }
		    }
		}
		
		for (int i = 1; i < M + 1; i++) {
		    if (matrix[i][1] == 1) {
	            a[i][1] = a[i-1][1] + 1;
	        } else {
	            a[i][1] = a[i-1][1];
	        }
		}
		
		for (int i = 1; i < M + 1; i++) {
		    if (matrix[i][1] == 2) {
	            b[i][1] = b[i-1][1] + 1;
	        } else {
	            b[i][1] = b[i-1][1];
	        }
		}
		
		for (int i = 1; i < M + 1; i++) {
		    if (matrix[i][1] == 3) {
	            c[i][1] = c[i-1][1] + 1;
	        } else {
	            c[i][1] = c[i-1][1];
	        }
		}
		
		for (int j = 1; j < N + 1; j++) {
	        if (matrix[1][j] == 1) {
	            a[1][j] = a[1][j-1] + 1;
	        } else {
	            a[1][j] = a[1][j-1];
	        }
	    }
	    
	    for (int j = 1; j < N + 1; j++) {
	        if (matrix[1][j] == 2) {
	            b[1][j] = b[1][j-1] + 1;
	        } else {
	            b[1][j] = b[1][j-1];
	        }
	    }
	    
	    for (int j = 1; j < N + 1; j++) {
	        if (matrix[1][j] == 3) {
	            c[1][j] = c[1][j-1] + 1;
	        } else {
	            c[1][j] = c[1][j-1];
	        }
	    }
		
		for (int i = 2; i < M + 1; i++) {
		    for (int j = 2; j < N + 1; j++) {
		        if (matrix[i][j] == 1) {
		            a[i][j] = a[i-1][j] + a[i][j-1] - a[i-1][j-1] + 1;
		        } else {
		            a[i][j] = a[i-1][j] + a[i][j-1] - a[i-1][j-1];
		        }
		    }
		}
		
		for (int i = 2; i < M + 1; i++) {
		    for (int j = 2; j < N + 1; j++) {
		        if (matrix[i][j] == 2) {
		            b[i][j] = b[i-1][j] + b[i][j-1] - b[i-1][j-1] + 1;
		        } else {
		            b[i][j] = b[i-1][j] + b[i][j-1] - b[i-1][j-1];
		        }
		    }
		}
		
		for (int i = 2; i < M + 1; i++) {
		    for (int j = 2; j < N + 1; j++) {
		        if (matrix[i][j] == 3) {
		            c[i][j] = c[i-1][j] + c[i][j-1] - c[i-1][j-1] + 1;
		        } else {
		            c[i][j] = c[i-1][j] + c[i][j-1] - c[i-1][j-1];
		        }
		    }
		}
		
		for (int i = 0; i < K; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
		    
		    sb.append(a[x2][y2] - a[x2][y1-1] - a[x1-1][y2] + a[x1-1][y1-1] + " ")
		        .append(c[x2][y2] - c[x2][y1-1] - c[x1-1][y2] + c[x1-1][y1-1] + " ")
		        .append(b[x2][y2] - b[x2][y1-1] - b[x1-1][y2] + b[x1-1][y1-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
