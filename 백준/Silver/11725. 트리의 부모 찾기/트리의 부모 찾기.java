import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a].add(b);
            matrix[b].add(a);
        }

        DFS(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void DFS(int v) {
        if (visited[v]) return;

        visited[v] = true;
        for (int i : matrix[v]) {
            if (!visited[i]) {
                parent[i] = v;
                DFS(i);
            }
        }
    }
}