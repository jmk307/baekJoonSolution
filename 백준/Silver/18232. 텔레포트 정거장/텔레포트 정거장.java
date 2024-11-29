import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M, S, E, x, y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[] visited = new boolean[300001];
    static ArrayList<Integer>[] matrix;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            matrix[x].add(y);
            matrix[y].add(x);
        }

        BFS(new Node(S, 0));
    }

    static void BFS(Node v) {
        visited[v.node] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.node == E) {
                System.out.println(now.count);
                break;
            }

            int a = now.node - 1;
            if (a > 0 && !visited[a]) {
                visited[a] = true;
                que.add(new Node(a, now.count + 1));
            }

            int b = now.node + 1;
            if (b <= N && !visited[b]) {
                visited[b] = true;
                que.add(new Node(b, now.count + 1));
            }

            for (int i = 0; i < matrix[now.node].size(); i++) {
                if (!visited[matrix[now.node].get(i)]) {
                    visited[matrix[now.node].get(i)] = true;
                    que.add(new Node(matrix[now.node].get(i), now.count + 1));
                }
            }
        }
    }
}

class Node {
    int node;

    int count;

    public Node(int node, int count) {
        this.node = node;
        this.count = count;
    }
}