import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, S;
    static int min = Integer.MAX_VALUE;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[] matrix;
    static int[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = matrix[0];
        if (sum >= S) {
            min = Math.min(min, 1);
        }

        while (end != N - 1) {
            end++;
            sum += matrix[end];

            if (sum >= S) {
                while (true) {
                    if (sum < S) {
                        break;
                    }

                    min = Math.min(min, end - start + 1);

                    sum -= matrix[start];
                    start++;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}