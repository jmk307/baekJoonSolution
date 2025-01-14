import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, K, X, A, B;
    static Set<Integer> answer = new TreeSet<>();

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static ArrayList<Integer>[] matrix;
    static int[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        visited = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            matrix[A].add(B);
        }

        BFS(X);

        boolean isAnswer = false;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == K) {
                isAnswer = true;
                System.out.println(i);
            }
        }

        if (!isAnswer) {
            System.out.println(-1);
        }
    }

    static void BFS(int v) {
        visited[v] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i : matrix[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    que.add(i);
                }
            }
        }
    }
}