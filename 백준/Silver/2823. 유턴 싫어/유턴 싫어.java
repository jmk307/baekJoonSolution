import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int R, C;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix, dp;
    static boolean[][] visited;
    static ArrayList<Integer>[] list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (arrays[j].equals("X")) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        boolean isValid = true;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0 && !check(i, j)) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    static boolean check(int a, int b) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < R && y < C) {
                if (matrix[x][y] == 0) {
                    count++;
                }
            }
        }

        return count >= 2;
    }
}