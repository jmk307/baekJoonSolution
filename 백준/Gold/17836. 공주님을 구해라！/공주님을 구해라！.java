import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, M, T;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] matrix;
	static boolean[][][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		matrix = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];
		
		for (int i = 1; i < N + 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j < M + 1; j++) {
		        matrix[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		BFS(new Node(new int[] {1, 1}, 0, 0));
		
		if (min == Integer.MAX_VALUE) {
		    System.out.println("Fail");
		} else {
		    if (min > T) {
		        System.out.println("Fail");
		    } else {
		        System.out.println(min);
		    }
		}
	}
	
	static void BFS(Node v) {
	    Queue<Node> que = new LinkedList<>();
	    que.add(v);
	    visited[v.node[0]][v.node[1]][0] = true;
	    
	    while (!que.isEmpty()) {
	        Node now = que.poll();
	        
	        if (now.node[0] == N && now.node[1] == M) {
	            min = Math.min(min, now.count);
	        }
	        
	        for (int i = 0; i < 4; i++) {
	            int x = now.node[0] + dx[i];
	            int y = now.node[1] + dy[i];
	            
	            if (x >= 1 && y >= 1 && x <= N && y <= M) {
	                if (matrix[x][y] == 0) {
	                    if (!visited[x][y][now.isGram]) {
	                        visited[x][y][now.isGram] = true;
	                        que.add(new Node(new int[] {x, y}, now.count + 1, now.isGram));
	                    }
                    } else if (matrix[x][y] == 1) {
                        if (now.isGram == 1 && !visited[x][y][1]) {
                            visited[x][y][now.isGram] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.isGram));
                        }
                    } else if (matrix[x][y] == 2) {
                        if (now.isGram == 0) {
                            visited[x][y][now.isGram + 1] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.isGram + 1));
                        }
                    }
	            }
	        }
	    }
	}
}

class Node {
    int[] node;
    
    int count;
    
    int isGram;
    
    public Node(int[] node, int count, int isGram) {
        this.node = node;
        this.count = count;
        this.isGram = isGram;
    }
}
