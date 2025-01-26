import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, L, R;
    static int max = 0;
    static int maxIndex = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    /*static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};*/

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append("LoveisKoreaUniversity" + " ");
        }

        System.out.println(sb);

        /*st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }*/
    }

    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int gap = Math.abs(matrix[now[0]][now[1]] - matrix[x][y]);

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (!visited[x][y] && gap >= L && gap <= R) {
                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}