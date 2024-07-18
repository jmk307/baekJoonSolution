import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int M, N, K;
    static int count;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[j][i] = 1;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            for (int j = M - y4; j < M - y1; j++) {
                for (int k = x1; k < x4; k++) {
                    matrix[k][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 & !visited[i][j]) {
                    count = 0;
                    DFS(i, j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (matrix[x][y] == 1 & !visited[x][y]) {
                    matrix[x][y] = 0;
                    DFS(x, y);
                }
            }
        }
    }
}