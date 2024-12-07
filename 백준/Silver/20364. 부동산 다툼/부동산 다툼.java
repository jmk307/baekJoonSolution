import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, Q;
    static int max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int now = Integer.parseInt(br.readLine());
            int check = now;
            int ans = 0;

            boolean isAnswer = true;
            while (check != 0) {
                if (visited[check]) {
                    ans = check;
                    isAnswer = false;
                }

                check /= 2;
            }

            if (isAnswer) {
                visited[now] = true;
                System.out.println(0);
            } else {
                System.out.println(ans);
            }
        }
    }
}