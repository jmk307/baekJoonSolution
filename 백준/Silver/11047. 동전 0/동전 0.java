import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    static Integer[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new Integer[N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(matrix, Collections.reverseOrder());

        int current = K;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int count = current / matrix[i];

            if (current >= matrix[i]) {
                current -= count * matrix[i];
            }

            if (count != 0) {
                result += count;
            }

            if (current == 0) {
                break;
            }
        }

        System.out.println(result);
    }
}