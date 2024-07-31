import java.lang.*;
import java.io.*;

public class Main {
    static int T;

    static int countZero;
    static int countOne;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int current = Integer.parseInt(br.readLine());

            matrix = new int[current + 1];
            for (int j = 0; j <= current; j++) {
                matrix[j] = -1;
            }
            matrix[0] = 0;
            if (current == 1) {
                matrix[1] = 0;
            } else if (current > 1) {
                matrix[1] = 0;
                matrix[2] = 1;
            }

            if (current == 0) {
                sb.append(1).append(" ");
            } else if (current == 1) {
                sb.append(0).append(" ");
            } else {
                sb.append(fibonacci(current)).append(" ");
            }

            matrix = new int[current + 1];
            for (int j = 0; j <= current; j++) {
                matrix[j] = -1;
            }
            matrix[0] = 0;
            if (current == 1) {
                matrix[1] = 0;
            } else if (current > 1) {
                matrix[1] = 1;
                matrix[2] = 1;
            }

            if (current == 0) {
                sb.append(0).append("\n");
            } else if (current == 1) {
                sb.append(1).append("\n");
            } else {
                sb.append(fibonacci(current)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int fibonacci(int N) {
        if (matrix[N] != -1) {
            return matrix[N];
        }

        return matrix[N] = fibonacci(N - 2) + fibonacci(N - 1);
    }
}