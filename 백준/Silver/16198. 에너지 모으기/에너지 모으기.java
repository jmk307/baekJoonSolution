import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);

        System.out.println(max);
    }

    static void backTracking(int depth, int sum) {
        if (depth == N - 2) {
            max = Math.max(max, sum);

            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int a = 0;
                for (int j = i + 1; j < N; j++) {
                    if (!visited[j]) {
                        a = matrix[j];
                        break;
                    }
                }

                int b = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (!visited[j]) {
                        b = matrix[j];
                        break;
                    }
                }

                backTracking(depth + 1, sum + a * b);

                visited[i] = false;
            }
        }
    }
}