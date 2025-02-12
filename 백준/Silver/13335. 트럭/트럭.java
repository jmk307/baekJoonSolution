import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, w, L;
    static int min = 1000 * 1000;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix;
    static int[][] dist;
    static boolean[][] visited;
    static Deque<Integer> deque = new ArrayDeque<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        matrix = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int count = 0;
        int sum = 0;

        while (true) {
            if (index == n) {
                break;
            }

            int size = deque.size();
            if (deque.isEmpty()) {
                deque.add(matrix[index]);
                sum += matrix[index];
                index++;
            } else {
                if (size == w) {
                    sum -= deque.poll();
                }

                if (sum + matrix[index] <= L) {
                    deque.add(matrix[index]);
                    sum += matrix[index];
                    index++;
                } else {
                    deque.add(0);
                }
            }

            count++;
        }

        count += w;

        System.out.println(count);
    }
}