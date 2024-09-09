import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static String[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[j][i] = "*";
            }
        }

        divideAndConquer(N / 3, N / 3, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[j][i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void divideAndConquer(int startX, int startY, int size) {
        if (size == 1) {
            return;
        }

        int current = size / 3;

        for (int i = startY; i < startY + current; i++) {
            for (int j = startX; j < startX + current; j++) {
                matrix[j][i] = " ";
            }
        }

        divideAndConquer(startX - current + current / 3, startY - current + current / 3, current);
        divideAndConquer(startX + current / 3, startY - current + current / 3, current);
        divideAndConquer(startX + current + current / 3, startY - current + current / 3, current);
        divideAndConquer(startX - current + current / 3, startY + current / 3, current);
        divideAndConquer(startX + current + current / 3, startY + current / 3, current);
        divideAndConquer(startX - current + current / 3, startY + current + current / 3, current);
        divideAndConquer(startX + current / 3, startY + current + current / 3, current);
        divideAndConquer(startX + current + current / 3, startY + current + current / 3, current);
    }
}