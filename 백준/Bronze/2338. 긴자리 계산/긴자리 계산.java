import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, K, Q, M, S, E;
	
	static int[] dp = new int[6001];
	static boolean[] visited = new boolean[6001];
	static Map<Integer, Integer> map = new HashMap<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		
		System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));
	}
}