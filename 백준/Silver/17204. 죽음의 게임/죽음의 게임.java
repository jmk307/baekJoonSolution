import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	
	static int[] matrix;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N];
		for (int i = 0; i < N; i++) {
		    matrix[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[N];
        int current = 0;
        int count = 0;
        
        while (!visited[current]) {
            if (current == K) {
                System.out.println(count);
                return;
            }
            visited[current] = true;
            current = matrix[current];
            count++;
        }
        
        System.out.println(-1); 
	}
}
