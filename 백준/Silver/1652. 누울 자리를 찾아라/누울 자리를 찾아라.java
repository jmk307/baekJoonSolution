import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (input[j] == '.') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    sum++;
                } else {
                    if (sum >= 2) {
                        count++;
                    }
                    sum = 0;
                }
            }

            if (sum >= 2) {
                count++;
            }
        }
        sb.append(count + " ");

        count = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if (matrix[j][i] == 0) {
                    sum++;
                } else {
                    if (sum >= 2) {
                        count++;
                    }
                    sum = 0;
                }
            }

            if (sum >= 2) {
                count++;
            }
        }
        sb.append(count);

        System.out.println(sb);
    }
}