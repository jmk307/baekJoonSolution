import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, r1, c1, r2, c2;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        BFS(r1, c1);

        System.out.println(answer);
    }

    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});
        matrix[a][b] = 0;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (now[0] == r2 && now[1] == c2) {
                answer = matrix[now[0]][now[1]];
                break;
            }

            for (int i = 0; i < 6; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}