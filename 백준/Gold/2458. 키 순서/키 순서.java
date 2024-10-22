import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M, a, b;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j<= N; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }

                if (matrix[j][i] == 1) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}