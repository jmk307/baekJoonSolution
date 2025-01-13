import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] matrix, a, b, c;
	static boolean[][][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String input;
		while ((input = br.readLine()) != null) {
		    if (input.isEmpty()) {
		        break;
		    }
		    
		    root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
	}
	
	static void postOrder(Node node) {
	    if (node == null) return;
	    
	    postOrder(node.left);
	    postOrder(node.right);
	    System.out.println(node.num);
	}
}

class Node {
    int num;
    
    Node left, right;
    
    Node(int num) {
        this.num = num;
    }
    
    Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }
    
    void insert(int n) {
        if (n < this.num) {
            if (this.left == null) {
                this.left = new Node(n);
            } else {
                this.left.insert(n);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(n);
            } else {
                this.right.insert(n);
            }
        }
    } 
}
