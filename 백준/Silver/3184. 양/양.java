import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int R, C;
    static int sheep = 0;
    static int wolf = 0;
    static int totalSheep = 0;
    static int totalWolf = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String now = arrays[j];

                if (now.equals(".")) {
                    matrix[i][j] = 0;
                } else if (now.equals("#")) {
                    matrix[i][j] = 1;
                } else if (now.equals("o")) {
                    matrix[i][j] = 2;
                } else {
                    matrix[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    sheep = 0;
                    wolf = 0;
                    DFS(i, j);

                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        System.out.print(totalSheep);
        System.out.print(" ");
        System.out.print(totalWolf);
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;

        if (matrix[a][b] == 2) {
            sheep++;
        } else if (matrix[a][b] == 3) {
            wolf++;
        }

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < R && y < C) {
                if (!visited[x][y] && matrix[x][y] != 1) {
                    DFS(x, y);
                }
            }
        }
    }
}