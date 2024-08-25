import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;

    static boolean[] visited;
    static int[] matrix, result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix);

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int i = 1; i < depth + 1; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth + 1] = matrix[i];
                DFS(depth + 1);

                visited[i] = false;
            }
        }
    }
}