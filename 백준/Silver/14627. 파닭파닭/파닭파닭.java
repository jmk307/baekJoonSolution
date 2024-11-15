import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int S, C;

    static long[] matrix;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new long[S];
        for (int i = 0; i < S; i++) {
            matrix[i] = Long.parseLong(br.readLine());
        }

        long start = 1;
        long end = 1000000000;

        while (start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (long i : matrix) {
                count += i / mid;
            }

            if (count < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        long sum = 0;
        for (long i : matrix) {
            sum += i;
        }

        long answer = sum - (end * C);

        System.out.println(answer);
    }
}