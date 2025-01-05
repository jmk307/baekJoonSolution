import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static long[][] dp;

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
		
		int lion = 0;
		
		if (matrix[start] == 1) {
		    lion++;
		}
		
		if (lion == K) {
	        min = Math.min(min, end - start + 1);
	    }
		
		while (true) {
		    if (end == N-1) {
		        break;
		    }
		    
		    end++;
		    if (matrix[end] == 1) {
        	    lion++;
        	}
        	
        	if (lion == K) {
		        min = Math.min(min, end - start + 1);
		        
    		    while (true) {
    		        if (matrix[start] == 1) {
        	            lion--;
        	        }
        	        
    		        start++;
    		        if (lion == K) {
    		            min = Math.min(min, end - start + 1);
    		        }
    		        
    		        if (matrix[start] == 1 && lion == K-1) {
    		            break;
    		        }
    		    }
		    }
		}
		
		if (min == Integer.MAX_VALUE) {
		    System.out.println(-1);
		} else {
		    System.out.println(min);
		}
	}
}
