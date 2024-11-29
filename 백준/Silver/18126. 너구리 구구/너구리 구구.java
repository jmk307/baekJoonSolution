import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, B, C;
    static long max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Node>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            matrix[A].add(new Node(B, C));
            matrix[B].add(new Node(A, C));
        }

        DFS(1, 0);

        System.out.println(max);
    }

    static void DFS(int v, long sum) {
        visited[v] = true;
        if (v != 1 && matrix[v].size() == 1) {
            max = Math.max(max, sum);
        }

        for (Node i : matrix[v]) {
            if (!visited[i.node]) {
                DFS(i.node, sum + i.value);
            }
        }
    }
}

class Node {
    int node;

    long value;

    public Node(int node, long value) {
        this.node = node;
        this.value = value;
    }
}