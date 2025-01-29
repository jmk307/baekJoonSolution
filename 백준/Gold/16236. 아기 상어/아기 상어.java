import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, S, E;
    static int current = 2;
    static int eatCount = 0;
    static int total;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[][] visited;
    static PriorityQueue<Node> pq;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                if (matrix[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;

                    matrix[i][j] = 0;
                }
            }
        }

        while (true) {
            pq = new PriorityQueue<>((e1, e2) -> {
                if (e1.count == e2.count) {
                    if (e1.node[0] == e2.node[0]) {
                        return e1.node[1] - e2.node[1];
                    } else {
                        return e1.node[0] - e2.node[0];
                    }
                } else {
                    return e1.count - e2.count;
                }
            });

            visited = new boolean[N][N];
            BFS(start[0], start[1]);

            if (pq.isEmpty()) {
                break;
            }

            Node next = pq.poll();

            start = next.node;
            total += next.count;

            matrix[next.node[0]][next.node[1]] = 0;
            eatCount++;

            if (eatCount == current) {
                eatCount = 0;
                current++;
            }
        }

        System.out.println(total);
    }

    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(new int[] {a, b}, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.node[0] + dx[i];
                int y = now.node[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (!visited[x][y]) {
                        if (matrix[x][y] == 0 || matrix[x][y] == current) {
                            visited[x][y] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1));
                        } else if (matrix[x][y] < current) {
                            visited[x][y] = true;
                            que.add(new Node(new int[] {x, y}, now.count + 1));

                            pq.add(new Node(new int[] {x, y}, now.count + 1));
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

    public Node(int[] node, int count) {
        this.node = node;
        this.count = count;
    }
}