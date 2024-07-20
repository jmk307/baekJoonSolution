import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] visitOrder;
    static int order;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];
        order = 1;

        for (int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            matrix[i].sort(Collections.reverseOrder());
        }

        DFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    static void DFS(int v) {
        visited[v] = true;
        visitOrder[v] = order++;

        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}