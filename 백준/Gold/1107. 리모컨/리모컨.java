import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static String N;
	static int M;
	static int K = 0;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static boolean[] visited = new boolean[10];
	static boolean[] broken = new boolean[10];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		
		if (M != 0) {
		    st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < M; i++) {
    		    broken[Integer.parseInt(st.nextToken())] = true;
    		}
		}
		
		
		for (int i = 1; i <= 7; i++) {
		    K = i;
		    matrix = new int[i];
		    backTracking(0);
		}
		
		min = Math.min(min, Math.abs(100 - Integer.parseInt(N)));
		
		System.out.println(min);
	}
	
	static void backTracking(int depth) {
	    if (depth == K) {
	        String result = "";
	        for (int i : matrix) {
	            result += String.valueOf(i);
	        }
	        
	        min = Math.min(min, K + Math.abs(Integer.parseInt(result) - Integer.parseInt(N)));
	        
	        return;
	    }
	    
	    for (int i = 0; i < 10; i++) {
	        if (!broken[i]) {
	            matrix[depth] = i;
                backTracking(depth + 1);
	        }
	    }
	}
}
