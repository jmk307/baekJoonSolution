import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int K, W, H;
    static int answer = -1;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] horseX = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] horseY = {2, 1, -2, -1, -2, -1, 2, 1};

    static int[][] matrix;
    static boolean[][][] visited;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        matrix = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(new Node(new int[] {0, 0}, 0, 0));

        System.out.println(answer);
    }

    static void BFS(Node v) {
        visited[v.node[0]][v.node[1]][0] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.node[0] == H-1 && now.node[1] == W-1) {
                answer = now.count;
                break;
            }

            if (now.horseCount < K) {
                for (int i = 0; i < 8; i++) {
                    int x = now.node[0] + horseX[i];
                    int y = now.node[1] + horseY[i];

                    if (x >= 0 && y >= 0 && x < H && y < W) {
                        if (!visited[x][y][now.horseCount + 1] && matrix[x][y] != 1) {
                            visited[x][y][now.horseCount + 1] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.horseCount + 1));
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int x = now.node[0] + dx[i];
                int y = now.node[1] + dy[i];

                if (x >= 0 && y >= 0 && x < H && y < W) {
                    if (!visited[x][y][now.horseCount] && matrix[x][y] != 1) {
                        visited[x][y][now.horseCount] = true;
                        que.add(new Node(new int[] {x, y}, now.count + 1, now.horseCount));
                    }
                }
            }
        }
    }
}

class Node {
    int[] node;

    int count;

    int horseCount;

    public Node(int[] node, int count, int horseCount) {
        this.node = node;
        this.count = count;
        this.horseCount = horseCount;
    }
}