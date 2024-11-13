import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(1, 1);

        if (visited[N][N]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int gap = matrix[now[0]][now[1]];

            int y = now[1] + gap;
            if (y < N + 1 && !visited[now[0]][y]){
                visited[now[0]][y] = true;
                que.add(new int[] {now[0], y});
            }

            int x = now[0] + gap;
            if (x < N + 1 && !visited[x][now[1]]){
                visited[x][now[1]] = true;
                que.add(new int[] {x, now[1]});
            }
        }
    }
}