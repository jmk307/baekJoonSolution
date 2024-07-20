import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[][] visited;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] arr = input.split("");
            for (int j = 0; j < M; j++) {
                matrix[j][i] = Integer.parseInt(arr[j]);
            }
        }

        BFS(0, 0);

        System.out.println(matrix[M-1][N-1]);
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

                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (matrix[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}