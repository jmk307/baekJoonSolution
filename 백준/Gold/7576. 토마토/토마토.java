import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]> start = new ArrayList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] matrix;
    static boolean[][] visited;

    static int M, N;
    static int max;
    static boolean isAll = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());

                if (matrix[j][i] == 1) {
                    start.add(new int[] {j, i});
                }
            }
        }

        BFS();

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[j][i] == 0) {
                    isAll = false;
                }

                max = Math.max(max, matrix[j][i]);
            }
        }

        if (!isAll) {
            System.out.println(-1);
        } else {
            if (max == 1) {
                System.out.println(0);
            } else {
                System.out.println(max - 1);
            }
        }
    }

    static void BFS() {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < start.size(); i++) {
            int[] node = start.get(i);
            que.add(node);
            visited[node[0]][node[1]] = true;
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (matrix[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}