import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static long N, L, W, H;

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        L = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());

        long min = Math.min(L, Math.min(W, H));

        long V = L * W * H;

        double start = 0;
        double end = min;

        while (start <= end) {
            double mid = (start + end) / 2;

            double current = (long) (L / mid) * (long) (W / mid) * (long) (H / mid);

            if (current < N) {
                if (end == mid) {
                    break;
                }

                end = mid;
            } else {
                if (start == mid) {
                    break;
                }

                start = mid;
            }
        }

        System.out.println(start);
    }
}