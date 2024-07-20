import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(matrix[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }

    static void DFS(int v) {
        if (visited[v]) return;
        System.out.print(v + " ");
        visited[v] = true;

        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;

        while (!que.isEmpty()) {
            int i = que.poll();
            System.out.print(i + " ");
            for (int j : matrix[i]) {
                if (!visited[j]) {
                    visited[j] = true;
                    que.add(j);
                }
            }
        }
    }
}