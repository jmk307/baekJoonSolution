import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] matrix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(matrix);

        for (int i = 0; i < N; i++) {
            sb.append(matrix[i]).append("\n");
        }

        System.out.println(sb);
    }
}