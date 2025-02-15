import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix;
    static int[][] dist;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        matrix = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        dist = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = 10000000;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(new int[] {1, 1}, 0));
        visited[1][1] = true;
        dist[1][1] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int[] now = nowNode.target;

            for (int i = 0; i < 2; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 1 && y >= 1 && x <= n && y <= n) {
                    if (matrix[now[0]][now[1]] > matrix[x][y]
                            && dist[x][y] > dist[now[0]][now[1]]) {
                        dist[x][y] = dist[now[0]][now[1]];
                        pq.add(new Node(new int[] {x, y}, dist[x][y]));
                    } else if (matrix[now[0]][now[1]] <= matrix[x][y]
                            && dist[x][y] > dist[now[0]][now[1]] + matrix[x][y] - matrix[now[0]][now[1]] + 1) {
                        dist[x][y] = dist[now[0]][now[1]] + matrix[x][y] - matrix[now[0]][now[1]] + 1;
                        pq.add(new Node(new int[] {x, y}, dist[x][y]));
                    }
                }
            }
        }

        return dist[n][n];
    }
}

class Node implements Comparable<Node> {
    int[] target;

    int value;

    public Node(int[] target, int value) {
        this.target = target;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}