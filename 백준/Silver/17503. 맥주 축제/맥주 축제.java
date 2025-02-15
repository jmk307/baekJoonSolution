import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, K, v, c;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix;
    static int[][] dist;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list.add(new int[] {v, c});
        }
        Collections.sort(list, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        int sum = 0;
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i)[0]);
            sum += list.get(i)[0];

            if (pq.size() > N) {
                sum -= pq.poll();
            }

            if (pq.size() == N && sum >= M) {
                result = list.get(i)[1];
                break;
            }
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}