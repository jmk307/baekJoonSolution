import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static String[][] matrix;
    static boolean[][] visited;

    static int N;
    static int count;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new String[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] array = input.split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = array[j];
            }
        }

        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS2(i, j);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb);
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < N && y < N) {
                if ((matrix[a][b].equals(matrix[x][y])) && !visited[x][y]) {
                    DFS(x, y);
                }
            }
        }
    }

    static void DFS2(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < N && y < N && !visited[x][y]) {
                if (matrix[a][b].equals("R") && matrix[x][y].equals("G")) {
                    DFS2(x, y);
                }
                
                if (matrix[a][b].equals("G") && matrix[x][y].equals("R")) {
                    DFS2(x, y);
                }

                if ((matrix[a][b].equals(matrix[x][y])) ) {
                    DFS2(x, y);
                }
            }
        }
    }
}