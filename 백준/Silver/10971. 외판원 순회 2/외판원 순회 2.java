import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static long min = Long.MAX_VALUE;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] matrix;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        result = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);

        System.out.println(min);
    }

    static void backTracking(int depth) {
        if (depth == N) {
            long sum = 0;
            boolean isAnswer = true;
            for (int i = 1; i < N; i++) {
                if (matrix[result[i-1]][result[i]] == 0) {
                    isAnswer = false;
                    break;
                } else {
                    sum += matrix[result[i-1]][result[i]];
                }
            }
            if (matrix[result[N-1]][result[0]] == 0) {
                isAnswer = false;
            } else {
                sum += matrix[result[N-1]][result[0]];
            }

            if (isAnswer) {
                min = Math.min(min, sum);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}