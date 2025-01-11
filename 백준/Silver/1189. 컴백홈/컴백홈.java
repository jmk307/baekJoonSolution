import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int R, C, K;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 1; j < C + 1; j++) {
                if (arrays[j-1].equals(".")) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        visited[R][1] = true;
        backTracking(R, 1, 1);

        System.out.println(count);
    }

    static void backTracking(int a, int b, int depth) {
        if (depth == K) {
            if (a == 1 && b == C) {
                count++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 1 && y >= 1 && x <= R && y <= C) {
                if (!visited[x][y] && matrix[x][y] == 0) {
                    visited[x][y] = true;
                    backTracking(x, y, depth + 1);
                    visited[x][y] = false;
                }
            }
        }
    }
}