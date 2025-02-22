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
		
		String input = br.readLine();
		
		if (input.equals("SONGDO")) {
		    System.out.println("HIGHSCHOOL");
		} else if (input.equals("CODE")) {
		    System.out.println("MASTER");
		} else if (input.equals("2023")) {
		    System.out.println("0611");
		} else {
		    System.out.println("CONTEST");
		}
	}
}
