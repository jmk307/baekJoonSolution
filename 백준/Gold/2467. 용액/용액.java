import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	static int N, M, a, b;
	static long min = Long.MAX_VALUE;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static long[] matrix;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		matrix = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    matrix[i] = Long.parseLong(st.nextToken());
		}
		
		long x = 0;
		long y = 0;
	    for (int i = 0; i < N - 1; i++) {
	        int start = i + 1;
    		int end = N;
    		while (start < end) {
    		    int mid = (start + end) / 2;
    		    long sum = Math.abs(matrix[i] + matrix[mid]);
    		    
    		    if (min > sum) {
    		        min = sum;
    		        x = matrix[i];
    		        y = matrix[mid];
    		    }
        		    
    		    if (matrix[mid] >= -matrix[i]) {
    		        end = mid;
    		    } else {
    		        start = mid + 1;
    		    }
    		}
    	}
    	
    	System.out.println(x + " " + y);
	}
}