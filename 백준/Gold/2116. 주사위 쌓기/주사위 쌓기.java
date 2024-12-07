import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dice = {5, 3, 4, 1, 2, 0};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int nowIndex = 0;
        int nextIndex = 0;
        int nowValue = 0;
        int nextValue = 0;
        for (int i = 0; i < 6; i++) {
            sum = 0;
            nowIndex = i;
            nextIndex = dice[i];
            int nowMax = 0;
            for (int j = 0; j < 6; j++) {
                if (j != nowIndex && j != nextIndex) {
                    nowMax = Math.max(nowMax, matrix[0][j]);
                }
            }
            sum += nowMax;

            nowValue = matrix[0][nextIndex];
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 6; k++) {
                    if (matrix[j][k] == nowValue) {
                        nowIndex = k;
                        nextIndex = dice[nowIndex];
                        break;
                    }
                }

                int current = 0;
                for (int k = 0; k < 6; k++) {
                    if (k != nowIndex && k != nextIndex) {
                        current = Math.max(current, matrix[j][k]);
                    }
                }
                nowValue = matrix[j][nextIndex];
                sum += current;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}