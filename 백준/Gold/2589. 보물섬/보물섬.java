import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;
    static int max = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (arrays[j].equals("L")) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                if (matrix[i][j] == 1) {
                    BFS(new Node(new int[] {i, j}, 0));
                }
            }
        }

        System.out.println(max);
    }

    static void BFS(Node v) {
        visited[v.node[0]][v.node[1]] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            Node now = que.poll();
            max = Math.max(max, now.count);

            for (int i = 0; i < 4; i++) {
                int x = now.node[0] + dx[i];
                int y = now.node[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y] && matrix[x][y] == 1) {
                        visited[x][y] = true;
                        que.add(new Node(new int[] {x, y}, now.count + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int[] node;

    int count;

    public Node(int[] node, int count) {
        this.node = node;
        this.count = count;
    }
}