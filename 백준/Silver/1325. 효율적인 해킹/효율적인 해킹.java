import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int rMax = -1;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] distance;

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

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[b].add(a);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];

            visited[i] = true;
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            int count = 0;

            while (!que.isEmpty()) {
                int now = que.poll();
                count++;

                for (int v: matrix[now]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        que.add(v);
                    }
                }
            }

            rMax = Math.max(rMax, count);

            list.add(count);
        }

        for (int i = 0; i < N; i++) {
            if (list.get(i) == rMax) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}