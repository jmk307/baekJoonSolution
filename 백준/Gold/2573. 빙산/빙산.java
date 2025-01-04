import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int answer = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static int[][] matrix;
    static int[][] melt;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = -1;
        while (true) {
            index++;

            visited = new boolean[N][M];
            melt = new int[N][M];

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && matrix[i][j] != 0) {
                        count++;
                        BFS(i, j);
                    }
                }
            }

            if (count >= 2) {
                answer = index;
                break;
            } else if (count == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] -= melt[i][j];
                    if (matrix[i][j] < 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void BFS(int a, int b) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});
        visited[a][b] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y] && matrix[x][y] != 0) {
                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                    } else if (matrix[x][y] == 0) {
                        count++;
                    }
                }
            }
            melt[now[0]][now[1]] = count;
        }
    }
}