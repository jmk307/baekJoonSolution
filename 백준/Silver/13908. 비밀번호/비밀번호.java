import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int n, m;
    static int result = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static boolean[] visited = new boolean[10];

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int now = Integer.parseInt(st.nextToken());
                visited[now] = true;
            }
        }

        backTracking(0, 0);

        System.out.println(result);
    }

    static void backTracking(int depth, int count) {
        if (depth == n) {
            if (count == m) {
                result++;
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                visited[i] = false;
                backTracking(depth + 1, count + 1);
                visited[i] = true;
            } else {
                backTracking(depth + 1, count);
            }
        }
    }
}