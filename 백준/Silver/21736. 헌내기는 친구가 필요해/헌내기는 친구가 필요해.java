import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N, M;
    static int x, y;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new String[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] arrays = input.split("");
            for (int j = 0; j < M; j++) {
                matrix[j][i] = arrays[j];
                if (arrays[j].equals("I")) {
                    x = j;
                    y = i;
                }
            }
        }

        DFS(x, y);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;

        if (matrix[a][b].equals("P")) {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < M && y < N && !visited[x][y]) {
                if (!matrix[x][y].equals("X")) {
                    DFS(x, y);
                }
            }
        }
    }
}