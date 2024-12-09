import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, K, S, X, Y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static boolean[][] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                if (matrix[i][j] != 0) {
                    pq.add(new Node(new int[] {i, j}, matrix[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        BFS();
        
        System.out.println(matrix[X][Y]);
    }

    static void BFS() {
        for (Node i : pq) {
            visited[i.node[0]][i.node[1]] = true;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.count == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = now.node[0] + dx[i];
                int y = now.node[1] + dy[i];

                if (x >= 1 && y >= 1 && x <= N && y <= N) {
                    if (!visited[x][y] && matrix[x][y] == 0) {
                        visited[x][y] = true;
                        matrix[x][y] = now.virus;
                        pq.add(new Node(new int[] {x, y}, now.virus, now.count + 1));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int[] node;

    int virus;

    int count;

    public Node(int[] node, int virus, int count) {
        this.node = node;
        this.virus = virus;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        if (this.count == o.count) {
            return this.virus - o.virus;
        } else {
            return this.count - o.count;
        }
    }
}