import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int white = 0;
    static int blue = 0;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        recursiveCall(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void recursiveCall(int n, int a, int b) {
        int start = matrix[a][b];
        boolean isSame = true;
        for (int i = b; i < b + n; i++) {
            for (int j = a; j < a + n; j++) {
                if (matrix[j][i] != start) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            if (start == 1) {
                blue++;
            } else {
                white++;
            }

            return;
        } else {
            int count = n / 2;
            recursiveCall(count, a, b);
            recursiveCall(count, a + count, b);
            recursiveCall(count, a, b + count);
            recursiveCall(count, a + count, b + count);
        }
    }
}