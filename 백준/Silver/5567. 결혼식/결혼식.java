import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, m, a, b;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        matrix = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            matrix[a].add(b);
            matrix[b].add(a);
        }

        BFS(new Node(1, 0));
        System.out.println(count);
    }

    static void BFS(Node v) {
        visited[v.node] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.depth == 1 || now.depth == 2) {
                count++;
            }

            for (int i : matrix[now.node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(new Node(i, now.depth + 1));
                }
            }
        }
    }
}

class Node {
    int node;

    int depth;

    public Node(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}