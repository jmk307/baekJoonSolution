import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, R, L;
	static int count = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] matrix;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] a = br.readLine().split("");
		
		String b = "";
		for (int i = a.length - 1; i >= 0; i--) {
		    b += a[i];
		}
		
		System.out.println(b);
	}
}
