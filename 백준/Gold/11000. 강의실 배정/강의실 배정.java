import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
       return e1[1] - e2[1];
    });

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][2];
        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[j][0] = a;
            matrix[j][1] = b;
        }

        Arrays.sort(matrix, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                count++;
                pq.add(new int[] {matrix[i][0], matrix[i][1]});
            } else {
                if (matrix[i][0] < pq.peek()[1]) {
                    count++;
                    pq.add(new int[] {matrix[i][0], matrix[i][1]});
                } else {
                    pq.poll();
                    pq.add(new int[] {matrix[i][0], matrix[i][1]});
                }
            }
        }

        System.out.println(count);
    }
}