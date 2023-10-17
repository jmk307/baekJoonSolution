import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] count = new int[26];
		for (int i = 0; i < count.length; i++) {
			count[i] = i + 10;
		}

		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());

		int result = 0;
		int counts = N.length() - 1;
		for (char c : N.toCharArray()) {
			if (Character.isDigit(c)) {
				result += Character.getNumericValue(c) * multiple(counts, B);
			} else {
				result += count[c - 'A'] * multiple(counts, B);
			}
			counts--;
		}
		System.out.println(result);
	}

	public static int multiple(int n, int B) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = result * B;
		}
		return result;
	}
}