import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int n, m, P, L;

    static PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());

    static int[][] matrix, dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < P; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int now = 0;
            if (P >= L) {
                for (int j = 0; j < L; j++) {
                    now = pq.poll();
                }
            } else {
                now = 1;
            }

            total += now;
            list.add(now);
        }

        int count = n;
        while (!list.isEmpty()) {
            if (total <= m) {
                break;
            }

            total -= list.poll();
            count--;
        }

        System.out.println(count);
    }
}