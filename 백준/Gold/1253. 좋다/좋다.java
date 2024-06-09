import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(input);

        int count = 0;

        for (int k = 0; k < N; k++) {
            long find = input[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {
                if (input[i] + input[j] == find) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        // i, j 가 같을때 인덱스 이동을 위함
                        i++;
                    } else if (j == k) {
                        // i, j 가 같을때 인덱스 이동을 위함
                        j--;
                    }
                } else if (input[i] + input[j] < find) {
                    i++;
                } else if (input[i] + input[j] > find) {
                    j--;
                }
            }
        }

        System.out.println(count);
    }
}