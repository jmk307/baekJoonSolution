import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int T, N;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int j = 0; j < T; j++) {
		    N = Integer.parseInt(br.readLine());
		    
		    matrix = new int[N];
		    
		    st = new StringTokenizer(br.readLine());
		    for (int i = 0; i < N; i++) {
		        pq.add(Integer.parseInt(st.nextToken()));
		    }
		    
		    for (int i = 0; i < N / 2; i++) {
		        matrix[i] = pq.poll();
		        matrix[N - 1 - i] = pq.poll();
		    }
		    
		    if (N % 2 == 1) {
		        matrix[N / 2] = pq.poll();
		    }
		    
		    int max = 0;
		    max = Math.max(max, Math.abs(matrix[0] - matrix[1]));
		    max = Math.max(max, Math.abs(matrix[0] - matrix[N-1]));
		    
		    for (int i = 1; i < N - 1; i++) {
		        max = Math.max(max, Math.abs(matrix[i] - matrix[i-1]));
		        max = Math.max(max, Math.abs(matrix[i] - matrix[i+1]));
		    }
		    
		    System.out.println(max);
		}
	}
}
