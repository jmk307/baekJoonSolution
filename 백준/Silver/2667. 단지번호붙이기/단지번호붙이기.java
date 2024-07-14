import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] towns;
    static boolean[][] visited;
    static int count = 0;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int num = 0;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        towns = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] arr = input.split("");
            for (int j = 0; j < n; j++) {
                towns[i][j] = Integer.parseInt(arr[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (towns[i][j] == 1 && !visited[i][j]) {
                    num = 1;
                    DFS(i, j);
                    list.add(num);
                }
            }
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
    
    static void DFS(int a, int b) {
        visited[a][b] = true;
        
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                if (towns[x][y] == 1 && !visited[x][y]) {
                    towns[x][y] = 0;
                    num++;
                    DFS(x, y);
                }
            }
        }
    }
}