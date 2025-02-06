import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, R, u, v;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static ArrayList<Integer>[] matrix;
    static int[] dist;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            matrix[u].add(v);
            matrix[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(matrix[i]);
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
        }
    }

    static void BFS(int v) {
        visited[v] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        dist = new int[N + 1];
        dist[R] = 1;
        int count = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i : matrix[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                    dist[i] = count;
                    que.add(i);
                }
            }
        }
    }
}