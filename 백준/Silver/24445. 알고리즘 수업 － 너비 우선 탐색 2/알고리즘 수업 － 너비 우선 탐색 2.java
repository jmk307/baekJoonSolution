import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, u, v;

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] answer;
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
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
        answer = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            matrix[u].add(v);
            matrix[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(matrix[i], Collections.reverseOrder());
        }

        BFS(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(answer[i]);
        }
    }

    static void BFS(int v) {
        visited[v] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            int now = que.poll();
            answer[now] = index;
            index++;

            for (int i : matrix[now])  {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}