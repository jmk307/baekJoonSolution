import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m;
    static int sX, sY;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (current == 2) {
                    matrix[j][i] = 0;
                    sX = j;
                    sY = i;
                } else {
                    matrix[j][i] = current;
                }
            }
        }

        BFS(sX, sY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[j][i] && matrix[j][i] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(matrix[j][i]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int a, int b) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});
        visited[a][b] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    if (matrix[x][y] == 1) {
                        visited[x][y] = true;
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}