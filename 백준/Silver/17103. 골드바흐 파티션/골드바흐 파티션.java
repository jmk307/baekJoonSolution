import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if (!prime[i]) {
				for (int j = i + i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			int result = 0;
			for (int j = 2; j <= n/2; j++) {
				if (!prime[j] && !prime[n - j]) {
					result += 1;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}