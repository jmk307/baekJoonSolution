import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] places = new int[N];

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			places[i] = Integer.parseInt(st2.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (places[i] > S) {
				places[i] = places[i] - S;
			} else {
				places[i] = S - places[i];
			}
		}

		System.out.println(gcd(places));
	}

	public static int gcd(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = gcd(result, arr[i]);
		}
		return result;
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}