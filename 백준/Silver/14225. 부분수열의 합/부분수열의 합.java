import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            matrix[i] = now;
            list.add(now);
        }

        visited = new boolean[100000001];

        backTracking(0, 0);

        for (int i = 1; i <= 100000001; i++) {
            if (!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    static void backTracking(int depth, int sum) {
        if (depth == N) {
            visited[sum] = true;

            return;
        }

        backTracking(depth + 1, sum);
        backTracking(depth + 1, sum + matrix[depth]);
    }
}