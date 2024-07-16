import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int w, h;

    static int[] dx = {0, -1, 0, 1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            num = 0;
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            matrix = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    matrix[j][i] = Integer.parseInt(st.nextToken());;
                }
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        num++;
                    }
                }
            }
            System.out.println(num);
        }
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && y >= 0 && x < w && y < h) {
                if (matrix[x][y] == 1 && !visited[x][y]) {
                    matrix[x][y] = 0;
                    DFS(x, y);
                }
            }
        }
    }
}