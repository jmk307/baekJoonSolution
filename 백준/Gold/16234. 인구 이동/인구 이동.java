import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, L, R;
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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        count += BFS(i, j);
                    }
                }
            }

            if (count == 0) {
                System.out.println(days);
                break;
            }

            days++;
        }

    }

    static int BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});

        int sum = 0;
        sum += matrix[a][b];
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {a, b});

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    int gap = Math.abs(matrix[x][y] - matrix[now[0]][now[1]]);
                    if (!visited[x][y] && gap >= L && gap <= R) {
                        sum += matrix[x][y];
                        list.add(new int[] {x, y});

                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }

        int result = sum / list.size();

        int total = 0;
        for (int[] i : list) {
            if (matrix[i[0]][i[1]] != result) {
                total++;
            }
            matrix[i[0]][i[1]] = result;
        }

        return total;
    }
}