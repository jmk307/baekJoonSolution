import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1];
        visited = new boolean[N + 1];

        DFS(0);

        System.out.println(sb);
    }

    static void DFS(int depth) {
        if (depth == N) {
            for (int i = 1; i < N + 1; i++) {
                sb.append(matrix[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                matrix[depth + 1] = i;
                DFS(depth + 1);

                visited[i] = false;
            }
        }
    }
}