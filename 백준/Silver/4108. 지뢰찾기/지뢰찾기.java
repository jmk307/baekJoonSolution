import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int R, C;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[][] matrix, result;
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> remain = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("0 0")) {
                break;
            }

            st = new StringTokenizer(input);
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            matrix = result = new int[R][C];

            for (int i = 0; i < R; i++) {
                String now = br.readLine();
                for (int j = 0; j < C; j++) {
                    if (now.charAt(j) == '.') {
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (matrix[i][j] == 0) {
                        result[i][j] = check(i, j);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (matrix[i][j] == -1) {
                        sb.append("*");
                    } else {
                        sb.append(result[i][j]);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static int check(int a, int b) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x < 0 || y < 0 || x >= R || y >= C) continue;

            if (matrix[x][y] == -1) {
                count++;
            }
        }

        return count;
    }
}