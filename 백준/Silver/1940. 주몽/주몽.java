import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        int i = 0;
        int j = N - 1;
        int count = 0;
        while (i < j) {
            if (input[i] + input[j] > M) {
                j--;
            } else if (input[i] + input[j] < M) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}