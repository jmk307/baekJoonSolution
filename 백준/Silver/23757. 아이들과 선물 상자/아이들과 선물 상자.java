import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static int[] matrix;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        matrix = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAnswer = true;
        for (int i : matrix) {
            if (pq.peek() >= i) {
                if (pq.peek() == i) {
                    pq.poll();
                } else {
                    pq.add(pq.poll() - i);
                }
            } else {
                isAnswer = false;
                break;
            }
        }

        if (isAnswer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}