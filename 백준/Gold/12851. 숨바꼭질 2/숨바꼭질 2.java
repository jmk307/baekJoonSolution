import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    static int[] visited = new int[100001];

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
        } else {
            BFS(N);

            System.out.println(min);
            System.out.println(count);
        }
    }

    static void BFS(int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        visited[n] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (min < visited[now]) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = now * 2;
                else if (i == 1) next = now + 1;
                else next = now - 1;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    min = visited[now];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    que.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}