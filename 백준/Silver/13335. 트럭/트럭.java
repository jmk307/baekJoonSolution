import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int n, w, L;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static Queue<Integer> que = new LinkedList<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= w; i++) {
		    que.add(0);
		}
		
		int count = 0;
		int index = 0;
		
		int total = w;
		int sum = 0;
		
		while (true) {
		    if (index == n) {
		        break;
		    }
		    
		    count++;
		    
		    if (!que.isEmpty()) {
		        total--;
		        sum -= que.poll();
		    }
		    
		    if (total < w) {
		        total++;
		        
		        if (sum + matrix[index] <= L) {
		            sum += matrix[index];
		            que.add(matrix[index]);
		            index++;
		        } else {
		            que.add(0);
		        }
		    }
		}
		
		System.out.println(que.size() + count);
	}
}
