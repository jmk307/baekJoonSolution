import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static String A, B;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		
		BigInteger a = new BigInteger(A);
		BigInteger b = new BigInteger(B);
		
		System.out.println(a.add(b));
	}
}
