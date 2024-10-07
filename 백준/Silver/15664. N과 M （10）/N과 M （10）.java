import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static int[] matrix;
    static boolean[] visited;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix);

        backTracking(0, 0);

        System.out.println(sb);
    }

    static void backTracking(int depth, int prev) {
        if (depth == M) {
            for (int i = 1; i < M + 1; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }

        int lastUsed = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && matrix[i] != lastUsed && matrix[i] >= prev) {
                visited[i] = true;
                result[depth + 1] = matrix[i];
                lastUsed = matrix[i];
                backTracking(depth + 1, matrix[i]);

                visited[i] = false;
            }
        }
    }
}