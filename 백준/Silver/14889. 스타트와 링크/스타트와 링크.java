import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 1);

        System.out.println(min);
    }

    static void backTracking(int depth, int index) {
        if (depth == N / 2) {
            int a = 0;
            int b = 0;
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (visited[i] && visited[j]) {
                        a += matrix[i][j];
                        a += matrix[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        b += matrix[i][j];
                        b += matrix[j][i];
                    }
                }
            }

            min = Math.min(min, (int) Math.abs(a - b));

            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }

            return;
        }

        for (int i = index; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}