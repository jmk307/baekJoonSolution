import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, K;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int current = 0;
        int idx = N - 1;
        visited = new boolean[N];

        while (idx > 0) {
            if (current + idx <= K) {
                current += idx;
                visited[idx] = true;
            }
            idx--;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (visited[i]) {
                System.out.print(i + 1 + " ");
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                System.out.print(i + 1 + " ");
            }
        }

    }
}