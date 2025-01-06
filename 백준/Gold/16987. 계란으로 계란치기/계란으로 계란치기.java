import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, S, W;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] matrix;
    static List<Integer> list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            matrix[i][0] = S;
            matrix[i][1] = W;
        }

        backTracking(0);

        System.out.println(max);
    }

    static void backTracking(int index) {
        if (index == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (matrix[i][0] <= 0) {
                    count++;
                }
            }

            max = Math.max(max, count);

            return;
        }

        boolean isBroken = true;
        for (int i = 0; i < N; i++) {
            if (matrix[index][0] > 0 && matrix[i][0] > 0 && i != index) {
                int now = matrix[index][1];
                int target = matrix[i][1];
                isBroken = false;

                matrix[index][0] -= target;
                matrix[i][0] -= now;

                backTracking(index + 1);

                matrix[index][0] += target;
                matrix[i][0] += now;
            }
        }

        if (isBroken) {
            backTracking(index + 1);
        }
    }
}