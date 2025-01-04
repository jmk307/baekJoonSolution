import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static int[][] matrix;
    static int[][] melt;
    static boolean[][][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for (int i = 1; i < N + 1; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                matrix[i][j] = Integer.parseInt(arrays[j-1]);
            }
        }

        BFS(1, 1);

        System.out.println(answer);
    }

    static void BFS(int a, int b) {
        visited[a][b][0] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(new int[] {a, b}, 0, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.node[0] == N && now.node[1] == M) {
                answer = now.count + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = now.node[0] + dx[i];
                int y = now.node[1] + dy[i];

                if (x >= 1 && y >= 1 && x <= N && y <= M) {
                    if (now.broken == 0) {
                        if (!visited[x][y][now.broken] && matrix[x][y] == 0) {
                            visited[x][y][0] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.broken));
                        }

                        if (!visited[x][y][now.broken + 1] && matrix[x][y] == 1) {
                            visited[x][y][1] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.broken + 1));
                        }
                    } else {
                        if (!visited[x][y][now.broken] && matrix[x][y] == 0) {
                            visited[x][y][now.broken] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1, now.broken));
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int[] node;

    int count;

    int broken;

    public Node(int[] node, int count, int broken) {
        this.node = node;
        this.count = count;
        this.broken = broken;
    }
}