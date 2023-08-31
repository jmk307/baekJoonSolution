import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String order = br.readLine();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();

		for (char c : order.toCharArray()) {
			if (map.containsKey(c)) {
				int result = map.get(c) + 1;
				map.put(c,  result);
			} else {
				map.put(c, 1);
			}
		}
		
		for (char i = 'a'; i <= 'z'; i++) {
			if (map.get(i) == null) {
				sb.append(0).append(' ');
			} else {
				sb.append(map.get(i)).append(' ');
			}
		}
		System.out.println(sb);
	}
}