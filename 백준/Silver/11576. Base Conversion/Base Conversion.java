import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(br.readLine());

		int middle = 0;

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = count - 1; i >=0; i--) {
			middle += Integer.parseInt(st2.nextToken()) * multiple(i, A);
		}

		List<Integer> list = new ArrayList<>();
        while (middle > 0) {
            list.add(middle % B);

            middle /= B;
        }

		StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
		System.out.println(sb);
	}

	public static int multiple(int n, int B) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = result * B;
		}
		return result;
	}
}