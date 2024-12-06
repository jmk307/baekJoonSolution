import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, A, B, C;
    static int wCount = 0;
    static int bCount = 0;
    static int count = 0;
    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (arrays[j].equals("B")) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 0;
                    if (matrix[i][j] == 1) {
                        wDFS(i, j);
                        wCount += count * count;
                    } else {
                        bDFS(i, j);
                        bCount += count * count;
                    }
                }
            }
        }

        System.out.print(wCount);
        System.out.print(" ");
        System.out.print(bCount);
    }

    static void bDFS(int a, int b) {
        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < M && y < N) {
                if (!visited[x][y] && matrix[x][y] == 0) {
                    bDFS(x, y);
                }
            }
        }
    }

    static void wDFS(int a, int b) {
        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < M && y < N) {
                if (!visited[x][y] && matrix[x][y] == 1) {
                    wDFS(x, y);
                }
            }
        }
    }
}