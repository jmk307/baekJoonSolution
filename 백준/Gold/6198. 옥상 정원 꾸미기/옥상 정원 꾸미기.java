import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static long[] matrix;
	static long[] result;
	static Stack<Long> stack = new Stack<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new long[N];
		
		for (int i = 0; i < N; i++) {
		    matrix[i] = Long.parseLong(br.readLine());
		}
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
		    long now = matrix[i];
		    
		    while (!stack.isEmpty() && now >= stack.peek()) {
		        stack.pop();
		    }
		    stack.push(now);
		    
		    sum += stack.size() - 1;
		}
		
		System.out.println(sum);
	}
}
