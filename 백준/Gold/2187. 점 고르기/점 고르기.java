import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, A, B, r, c, S;
    static int min = 1000 * 1000;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix;
    static int[][] dist;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int maxR = 0;
        int maxC = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            maxR = Math.max(maxR, r);
            maxC = Math.max(maxC, c);

            list.add(new int[] {r, c, S});
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] now = list.get(i);
            for (int j = 0; j < N; j++) {
                if (Math.abs(now[0] - list.get(j)[0]) < A && Math.abs(now[1] - list.get(j)[1]) < B && i != j) {
                    int a = Math.max(now[2], list.get(j)[2]);
                    int b = Math.min(now[2], list.get(j)[2]);

                    answer = Math.max(answer, a - b);
                }
            }
        }

        System.out.println(answer);
    }
}