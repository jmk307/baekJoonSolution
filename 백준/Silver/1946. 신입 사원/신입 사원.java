import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
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
            int flag = 0;
            for (int j = 1; j < N; j++) {
                if (matrix[flag][1] < matrix[j][1]) {
                    count++;
                } else if (matrix[flag][1] > matrix[j][1]) {
                    flag = j;
                }
            }

            System.out.println(N - count);
        }
    }
}