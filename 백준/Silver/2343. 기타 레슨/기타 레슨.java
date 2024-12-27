import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static long[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new long[N];

        st = new StringTokenizer(br.readLine());
        long total = 0;
        long max = 0;
        for (int i = 0; i < N ; i++) {
            matrix[i] = Long.parseLong(st.nextToken());
            total += matrix[i];
            max = Math.max(max, matrix[i]);
        }

        long start = max - 1;
        long end = total + 1;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            long sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                sum += matrix[i];

                if (sum > mid) {
                    count++;
                    sum = matrix[i];
                }
            }

            if (count < M) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(end);
    }
}