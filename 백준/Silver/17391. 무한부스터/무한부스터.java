import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix, dp;
    static boolean[][] visited;
    static int[][] dist;
    static ArrayList<Integer>[] list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0, 0);

        System.out.println(dist[N-1][M-1]);
    }

    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});
        dist[a][b] = 0;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            
            if (now[0] == N - 1 && now[1] == M - 1) {
                break;
            }

            int current = matrix[now[0]][now[1]];

            for (int i = 1; i <= current; i++) {
                int x = now[0] + i;
                int y = now[1];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                        dist[x][y] = dist[now[0]][now[1]] + 1;
                    }
                }

                x = now[0];
                y = now[1] + i;

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                        dist[x][y] = dist[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}