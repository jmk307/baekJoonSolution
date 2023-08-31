import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String order = br.readLine();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();

		for (char i = 'a'; i <= 'z'; i++) {
			map.put(i, -1);
		}

		char[] chars = order.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.get(order.charAt(i)) != -1) {
				continue;
			} else {
				map.put(order.charAt(i), i);
			}
		}

		for (char i = 'a'; i <= 'z'; i++) {
			sb.append(map.get(i)).append(' ');
		}

		System.out.println(sb);
	}
}