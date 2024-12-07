import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, a, b, c, x, y;
    static int max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Node>[] matrix;
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

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            matrix[a].add(new Node(b, c));
            matrix[b].add(new Node(a, c));
        }

        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            DFS(new Node(x, 0));
        }
    }

    static void DFS(Node v) {
        visited[v.end] = true;
        if (v.end == y) {
            System.out.println(v.value);
            return;
        }

        for (Node i : matrix[v.end]) {
            if (!visited[i.end]) {
                DFS(new Node(i.end, v.value + i.value));
            }
        }
    }
}

class Node {
    int end;

    int value;

    public Node(int end, int value) {
        this.end = end;
        this.value = value;
    }
}