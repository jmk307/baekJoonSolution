import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static long[] matrix;
    static List<Long> sum = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new long[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(matrix);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum.add(matrix[i] + matrix[j]);
            }
        }
        Collections.sort(sum);

        long max = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++)  {
                long now = matrix[i] - matrix[j];

                int start = 0;
                int end = sum.size() - 1;

                while (start < end) {
                    int midi = (start + end) / 2;
                    long midv = sum.get(midi);

                    if (midv <= now) {
                        if (midv == now) {
                            max = Math.max(max, matrix[i]);
                        }
                        start = midi + 1;
                    } else {
                        end = midi - 1;
                    }
                }
            }
        }

        System.out.println(max);
    }
}