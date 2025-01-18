import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N, K;
    static int max = Integer.MIN_VALUE;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix, replace;
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            matrix = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[j] = Integer.parseInt(st.nextToken());
            }

            int sum = matrix[0];
            int max = Integer.MIN_VALUE;
            max = Math.max(max, sum);
            for (int j = 1; j < N; j++) {
                if (sum + matrix[j] < matrix[j]) {
                    sum = matrix[j];
                } else {
                    sum += matrix[j];
                }

                max = Math.max(max, sum);
            }

            System.out.println(max);
        }
    }
}