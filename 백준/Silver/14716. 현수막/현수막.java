import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int M, N;

    static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[j][i] == 1 && !visited[j][i]) {
                    DFS(j, i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (!visited[x][y] && matrix[x][y] == 1) {
                    DFS(x, y);
                }
            }
        }
    }
}