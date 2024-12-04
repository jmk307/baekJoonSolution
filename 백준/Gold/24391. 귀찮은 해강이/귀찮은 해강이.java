import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, M, i, j;
	
	static int[] parent;
	static int[] A;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
		    parent[i] = i;
		}
		
		A = new int[N + 1];
		
		for (int k = 0; k < M; k++) {
		    st = new StringTokenizer(br.readLine());
		    
		    i = Integer.parseInt(st.nextToken());
		    j = Integer.parseInt(st.nextToken());
		    
		    union(i, j);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i = 2; i < N + 1; i++) {
		    if (find(A[i]) != find(A[i-1])) {
		        count++;
		    }
		}
		
		System.out.println(count);
	}
	
	static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
