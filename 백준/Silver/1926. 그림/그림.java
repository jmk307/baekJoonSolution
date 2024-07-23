import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m;
    static int count;

    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[j][i] && matrix[j][i] == 1) {
                    count = 0;
                    DFS(j, i);
                    list.add(count);
                }
            }
        }
        
        if (list.isEmpty()) {
            System.out.println(list.size());
            System.out.println(0);
        } else {
            System.out.println(list.size());
            System.out.println(Collections.max(list));
        }
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >=0 && x < m && y < n) {
                if (!visited[x][y] && matrix[x][y] == 1) {
                    visited[x][y] = true;
                    DFS(x, y);
                }
            }
        }
    }
}