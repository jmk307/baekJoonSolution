import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, K;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, matrix[i]);
        }

        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;

            int count = 0;
            for (int i : matrix) {
                count += i / mid;
            }

            if (count >= K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}