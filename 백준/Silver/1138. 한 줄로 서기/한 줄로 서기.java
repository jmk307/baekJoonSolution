import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix, result, total;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];
        visited = new boolean[N + 1];
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
    }

    static void backTracking(int depth) {
        if (depth == N) {
            total = new int[N];
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (result[i] < result[j]) {
                        count++;
                    }
                }
                total[result[i]-1] = count;
            }

            if (Arrays.equals(total, matrix)) {
                for (int i = 0; i < N; i++) {
                    System.out.print(result[i] + " ");
                }
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}