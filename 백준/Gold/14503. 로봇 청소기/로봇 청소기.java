import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, r, c, d;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            if (matrix[r][c] == 0) {
                count++;
                matrix[r][c] = 2;
            }

            boolean isAvailable = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;

                int a = r + direction[d][0];
                int b = c + direction[d][1];

                if (a >= 0 && b >= 0 && a < N && b < M && matrix[a][b] == 0) {
                    r = a;
                    c = b;
                    isAvailable = true;
                    break;
                }
            }

            if (!isAvailable) {
                int x = r + direction[(d + 2) % 4][0];
                int y = c + direction[(d + 2) % 4][1];

                if (x >= 0 && y >= 0 && x < N && y < M && matrix[x][y] == 2 || matrix[x][y] == 0) {
                    r = x;
                    c = y;
                } else if (matrix[x][y] == 1) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}