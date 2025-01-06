import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, a, b, k;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[] matrix, calc, result;
    static long[][] dp;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1];
        calc = new int[N + 2];
        result = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            calc[a] += k;
            calc[b+1] += k * -1;
        }

        result[1] = calc[1];
        for (int i = 2; i < N + 1; i++) {
            result[i] = result[i-1] + calc[i];
        }

        for (int i = 1; i < N + 1; i++) {
            matrix[i] += result[i];
        }
        
        for (int i = 1; i < N + 1; i++) {
            System.out.print(matrix[i] + " ");
        }
    }
}