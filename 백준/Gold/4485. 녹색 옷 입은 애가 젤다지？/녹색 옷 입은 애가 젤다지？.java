import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int min = 1000 * 1000;

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

        String input;
        int index = 1;
        while ((input = br.readLine()) != null) {
            if (input.equals("0")) {
                break;
            }

            N = Integer.parseInt(input);

            matrix = new int[N][N];
            visited = new boolean[N][N];

            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = 1000000;
                }
            }


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(0, 0);

            sb.append("Problem " + index + ": " + result).append("\n");
            index++;
        }

        System.out.println(sb);
    }

    static int dijkstra(int a, int b) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(new int[] {a, b}, matrix[0][0]));
        dist[0][0] = matrix[0][0];

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int[] now = nowNode.target;

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (!visited[x][y] && dist[x][y] > dist[now[0]][now[1]] + matrix[x][y]) {
                        visited[x][y] = true;
                        dist[x][y] = dist[now[0]][now[1]] + matrix[x][y];
                        pq.add(new Node(new int[] {x, y}, dist[x][y]));
                    }
                }
            }
        }

        return dist[N-1][N-1];
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