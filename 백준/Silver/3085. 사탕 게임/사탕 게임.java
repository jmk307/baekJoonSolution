import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, L, H;
    static int max = 0;
    static int maxIndex = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static char[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.charAt(j);
            }
        }

        check();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N-1 && j == N-1) continue;

                if (j == N - 1) {
                    char temp = matrix[i][j];
                    matrix[i][j] = matrix[i+1][j];
                    matrix[i+1][j] = temp;

                    check();

                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i+1][j];
                    matrix[i+1][j] = temp;
                } else if (i == N - 1) {
                    char temp = matrix[i][j];
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = temp;

                    check();

                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = temp;
                } else {
                    char temp = matrix[i][j];
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = temp;

                    check();

                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = temp;

                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i+1][j];
                    matrix[i+1][j] = temp;

                    check();

                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i+1][j];
                    matrix[i+1][j] = temp;
                }
            }
        }

        System.out.println(max);
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            char prev = matrix[i][0];
            int sum = 1;
            for (int j = 1; j < N; j++) {
                if (prev == matrix[i][j]) {
                    sum++;
                } else {
                    sum = 1;
                }
                prev = matrix[i][j];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < N; i++) {
            char prev = matrix[0][i];
            int sum = 1;
            for (int j = 1; j < N; j++) {
                if (prev == matrix[j][i]) {
                    sum++;
                } else {
                    sum = 1;
                }
                prev = matrix[j][i];
                max = Math.max(max, sum);
            }
        }
    }
}