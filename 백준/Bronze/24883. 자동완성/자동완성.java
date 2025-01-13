import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] dp;
	static boolean[][][] visited;
	static Map<Integer, Integer> map = new HashMap<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		
		if (input.equals("N") || input.equals("n")) {
		    System.out.println("Naver D2");
		} else {
		    System.out.println("Naver Whale");
		}
	}
}
