import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int V, E, A, B, C;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
		    parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    A = Integer.parseInt(st.nextToken());
		    B = Integer.parseInt(st.nextToken());
		    C = Integer.parseInt(st.nextToken());
		    
		    pq.add(new Edge(A, B, C));
		}
		
		int count = 0;
		int result = 0;
		while (count < V - 1) {
		    Edge now = pq.poll();
		    
		    if (find(now.s) != find(now.e)) {
		        count++;
		        union(now.s, now.e);
		        result += now.v;
		    }
		}
		
		System.out.println(result);
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

class Edge implements Comparable<Edge> {
    int s;
    
    int e;
    
    int v;
    
    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.v - o.v;
    }
}
