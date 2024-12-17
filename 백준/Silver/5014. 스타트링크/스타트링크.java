import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int F, S, G, U, D;
    static int answer = -1;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        BFS(S);

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        visited[v] = true;
        que.add(v);
        matrix = new int[F + 1];
        matrix[v] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == G) {
                answer = matrix[now];

                break;
            }

            if (now + U <= F && !visited[now + U]) {
                visited[now + U] = true;
                que.add(now + U);
                matrix[now + U] = matrix[now] + 1;
            }

            if (now - D >= 1 && !visited[now - D]) {
                visited[now - D] = true;
                que.add(now - D);
                matrix[now - D] = matrix[now] + 1;
            }
        }
    }
}