import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int H, W;
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
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		matrix = new int[W];
		
		int sum = H * W;
		int idx = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
		    matrix[i] = Integer.parseInt(st.nextToken());
		    sum -= matrix[i];
		    max = Math.max(max, matrix[i]);
		    
		    if (max == matrix[i]) {
		        idx = i;
		    }
		}
		sum -= (H - max);
		
		int current = matrix[0];
		int currentIdx = 0;
		for (int i = 1; i <= idx; i++) {
		    if (matrix[i] >= current) {
		        sum -= (i - currentIdx) * (H - current);
		        
		        currentIdx = i;
		        current = matrix[i];
		    }
		}
		
		current = matrix[W-1];
		currentIdx = W-1;
		for (int i = W-2; i >= idx; i--) {
		    if (matrix[i] >= current) {
		        sum -= (currentIdx - i) * (H - current);
		        
		        currentIdx = i;
		        current = matrix[i];
		    }
		}
		
		System.out.println(sum);
	}
}
