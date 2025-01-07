import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, R;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[][] matrix;
    static int[] linear, replace;
    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 1;
        int y = 1;
        int r = N;
        int c = M;
        int count = 1;

        while (r * c != 0) {
            linear = new int[r*c - (r-2)*(c-2) + 1];
            replace = new int[r*c - (r-2)*(c-2) + 1];
            int index = 1;

            for (int i = x; i < x + r; i++) {
                linear[index] = matrix[i][y];
                index++;
            }
            x += (r - 1);

            for (int i = y + 1; i < y + c; i++) {
                linear[index] = matrix[x][i];
                index++;
            }
            y += (c - 1);

            for (int i = x - 1; i > x - r; i--) {
                linear[index] = matrix[i][y];
                index++;
            }
            x -= r;
            x++;

            for (int i = y - 1; i > y - c + 1; i--) {
                linear[index] = matrix[x][i];
                index++;
            }
            y -= c;
            y += 2;

            for (int i = 1; i < r*c - (r-2)*(c-2) + 1; i++) {
                replace[(i + R) % (r*c - (r-2)*(c-2))] = linear[i];
            }

            x = count;
            y = count;
            index = 1;

            for (int i = x; i < x + r; i++) {
                matrix[i][y] = replace[index];
                index++;
            }
            x += (r - 1);

            for (int i = y + 1; i < y + c; i++) {
                matrix[x][i] = replace[index];
                index++;
            }
            y += (c - 1);

            for (int i = x - 1; i > x - r; i--) {
                matrix[i][y] = replace[index];
                index++;
            }
            x -= r;
            x++;

            for (int i = y - 1; i > y - c + 1; i--) {
                matrix[x][i] = replace[index];
                index++;
            }
            y -= c;
            y += 2;
            matrix[x][y] = replace[0];

            r -= 2;
            c -= 2;
            x++;
            count++;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}