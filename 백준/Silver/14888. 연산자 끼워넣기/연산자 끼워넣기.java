import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static int[] calc = new int[4];
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];
        result = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void backTracking(int depth) {
        if (depth == N - 1) {
            long sum = matrix[0];

            for (int i = 1; i < N; i++) {
                if (result[i-1] == 0) {
                    sum += matrix[i];
                } else if (result[i-1] == 1) {
                    sum -= matrix[i];
                } else if (result[i-1] == 2) {
                    sum *= matrix[i];
                } else {
                    sum /= matrix[i];
                }
            }

            min = Math.min(min, sum);
            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calc[i] != 0) {
                calc[i]--;
                result[depth] = i;
                backTracking(depth + 1);
                calc[i]++;
            }
        }
    }
}