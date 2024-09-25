import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M, u, v;

    static int count = 0;

    static ArrayList<Integer>[] matrix = new ArrayList[200001];
    static boolean[] visited = new boolean[200001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            matrix[u].add(v);
            matrix[v].add(u);
        }

        long sum = 1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count = 0;
                DFS(i);
                sum = (sum * count) % 1000000007;
            }
        }

        System.out.println(sum % 1000000007);
    }

    static void DFS(int v) {
        visited[v] = true;
        count++;

        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}