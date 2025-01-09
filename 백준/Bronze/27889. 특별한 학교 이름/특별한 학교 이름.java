import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int x, y;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static long[] matrix;
	static long[] result;
	static Map<String, String> map = new HashMap<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map.put("NLCS", "North London Collegiate School");
		map.put("BHA", "Branksome Hall Asia");
		map.put("KIS", "Korea International School");
		map.put("SJA", "St. Johnsbury Academy");
		
		System.out.println(map.get(br.readLine()));
	}
}
