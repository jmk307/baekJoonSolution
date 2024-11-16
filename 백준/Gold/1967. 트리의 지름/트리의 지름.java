import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int max = 0;
	static int start = 0;

	static ArrayList<Node>[] matrix;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
		    System.out.println(0);
		} else {
		    matrix = new ArrayList[n + 1];
    		for (int i = 1; i <= n; i++) {
    			matrix[i] = new ArrayList<>();
    		}
    		visited = new boolean[n + 1];
    
    		for (int i = 0; i < n - 1; i++) {
    			st = new StringTokenizer(br.readLine());
    
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			int c = Integer.parseInt(st.nextToken());
    
    			matrix[a].add(new Node(b, c));
    			matrix[b].add(new Node(a, c));
    		}
    
    		DFS(new Node(1, 0), 0);
    		
    		visited = new boolean[n + 1];
    		DFS(new Node(start, 0), 0);
    		System.out.println(max);
		}
	}

	static void DFS(Node n, int sum) {
	    visited[n.target] = true;
	    
	    if (n.target != 1 && matrix[n.target].size() == 1) {
	        max = Math.max(max, sum);
	        
	        if (max == sum) {
	            start = n.target;
	        }
	    }
	    
		for (Node i : matrix[n.target]) {
		    if (!visited[i.target]) {
		        DFS(new Node(i.target, i.value), sum + i.value);
		    }
		}
	}
}

class Node {
	int target;

	int value;

	public Node(int target, int value) {
		this.target = target;
		this.value = value;
	}
}
