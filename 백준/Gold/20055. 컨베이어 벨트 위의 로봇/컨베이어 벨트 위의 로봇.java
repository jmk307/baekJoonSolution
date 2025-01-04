import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static long max = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix, robot;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[2*N];
		robot = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
		    matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		while (true) {
		    index++;
		    
		    int temp = matrix[2*N - 1];
    		for (int i = 2*N - 1; i > 0; i--) {
    		    matrix[i] = matrix[i-1];
    		}
    		matrix[0] = temp;
    		
    		for (int i = N-1; i > 0; i--) {
    		    robot[i] = robot[i-1];
    		}
    		
    		robot[0] = 0;
    		robot[N-1] = 0;
    		
    		for (int i = N - 1; i > 0; i--) {
    		    if (robot[i-1] == 1 && robot[i] == 0 && matrix[i] > 0) {
    		        robot[i-1] = 0;
    		        robot[i] = 1;
    		        matrix[i]--;
    		        robot[N-1] = 0;
    		    }
    		}
    		
    		
    		if (matrix[0] > 0) {
    		    robot[0] = 1;
    		    matrix[0]--;
    		}
    		
    		int count = 0;
    		for (int i = 0; i < N*2; i++) {
    		    if (matrix[i] == 0) {
    		        count++;
    		    }
    		}
    		
    		if (count >= K) {
    		    break;
    		}
		}
		
		System.out.println(index);
	}
}