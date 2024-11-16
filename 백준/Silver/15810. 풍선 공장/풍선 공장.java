import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static long[] matrix;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new long[N];

        st = new StringTokenizer(br.readLine());
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(st.nextToken());
            min = Math.min(min, matrix[i]);
        }

        long start = 1;
        long end = min * M + 1;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (long i : matrix) {
                count += mid / i;
            }

            if (count >= M) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        System.out.println(end);
    }
}