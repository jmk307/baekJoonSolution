import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;
    static long x, y;

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
        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(matrix);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());
            int finalStart = 0;
            int finalEnd = 0;

            int start = 0;
            int end = matrix.length-1;

            while (start <= end) {
                int midi = (start + end) / 2;
                long midv = matrix[midi];

                if (midv >= x) {
                    end = midi - 1;
                } else {
                    start = midi + 1;
                }
            }

            finalStart = start;

            start = 0;
            end = matrix.length-1;

            while (start <= end) {
                int midi = (start + end) / 2;
                long midv = matrix[midi];

                if (midv > y) {
                    end = midi - 1;
                } else {
                    start = midi + 1;
                }
            }

            finalEnd = end;

            if (finalStart > finalEnd) {
                System.out.println(0);
            } else {
                System.out.println(finalEnd - finalStart + 1);
            }
        }
    }
}