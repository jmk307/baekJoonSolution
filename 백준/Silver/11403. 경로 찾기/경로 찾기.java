import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N + 1];


        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    matrix[i].add(j);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            BFS(i);
            for (int j = 1; j < N + 1; j++) {
                if (visited[j]) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i : matrix[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}