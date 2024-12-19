import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, d, k, c;
    static int max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static int[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new int[N + k - 1];
        visited = new int[d + 1];

        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < N + k - 1; i++) {
            matrix[i] = matrix[i - N];
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (visited[matrix[i]] == 0) {
                count++;
            }
            visited[matrix[i]]++;
        }

        if (visited[c] == 0) {
            max = Math.max(max, count + 1);
        } else {
            max = Math.max(max, count);
        }

        for (int i = 1; i < N; i++) {
            visited[matrix[i-1]]--;
            if (visited[matrix[i-1]] == 0) {
                count--;
            }

            if (visited[matrix[i + k - 1]] == 0) {
                count++;
            }
            visited[matrix[i + k - 1]]++;

            if (visited[c] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}