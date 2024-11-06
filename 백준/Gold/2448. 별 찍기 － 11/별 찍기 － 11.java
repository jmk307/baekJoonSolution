import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static String[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                matrix[i][j] = "*";
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                matrix[i][j] = " ";
                matrix[i][2*N - 2 - j] = " ";
            }
        }

        divideAndConquer(0, (2 * N - 1) / 2, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void divideAndConquer(int a, int b, int size) {
        if (size == 3) {
            matrix[a+1][b] = " ";

            return;
        }

        for (int i = a + size / 2; i < a + size; i++) {
            for (int j = i; j < a + size; j++) {
                int gap = j - i;
                matrix[i][b + gap] = " ";
                matrix[i][b - gap]= " ";
            }
        }

        divideAndConquer(a, b, size / 2);
        divideAndConquer(a + size / 2, b - size / 2, size / 2);
        divideAndConquer(a + size / 2, b + size / 2, size / 2);
    }
}