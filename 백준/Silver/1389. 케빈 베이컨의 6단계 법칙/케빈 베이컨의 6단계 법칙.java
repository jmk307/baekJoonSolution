import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M, A, B, target;
    static int kevinBacon = Integer.MAX_VALUE;
    static int count = 0;

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            matrix[A].add(B);
            matrix[B].add(A);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            count = 0;
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    visited = new boolean[N + 1];
                    target = i;

                    BFS(new Node(j, 0));
                }
            }

            list.add(count);
        }

        int min = Collections.min(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min) {
                kevinBacon = Math.min(kevinBacon, i + 1);
            }
        }

        System.out.println(kevinBacon);
    }

    static void BFS(Node node) {
        visited[node.v] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.v == target) {
                count += now.depth;
                break;
            }

            for (int i : matrix[now.v]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(new Node(i, now.depth + 1));
                }
            }
        }
    }
}

class Node {
    int v;

    int depth;

    public Node(int v, int depth) {
        this.v = v;
        this.depth = depth;
    }
}