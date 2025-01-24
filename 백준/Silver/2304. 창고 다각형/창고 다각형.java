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

    static int[][] matrix;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            matrix[i][0] = L;
            matrix[i][1] = H;

            max = Math.max(max, H);

            if (max == H) {
                maxIndex = L;
            }
        }

        Arrays.sort(matrix, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        int index = matrix[0][0];
        int nowheight = matrix[0][1];
        int sum = (matrix[N-1][0] + 1 - matrix[0][0]) * max;

        for (int i = 1; i < N; i++) {
            if (matrix[i][1] == max) {
                sum -= (matrix[i][0] - index) * (max - nowheight);
                break;
            } else {
                if (nowheight < matrix[i][1]) {
                    sum -= (matrix[i][0] - index) * (max - nowheight);

                    index = matrix[i][0];
                    nowheight = matrix[i][1];
                }
            }
        }

        index = matrix[N-1][0] + 1;
        nowheight = matrix[N-1][1];
        for (int i = N - 2; i >= 0; i--) {
            if (matrix[i][1] == max) {
                sum -= (index - matrix[i][0] - 1) * (max - nowheight);
                break;
            } else {
                if (nowheight < matrix[i][1]) {
                    sum -= (index - matrix[i][0] - 1) * (max - nowheight);

                    index = matrix[i][0] + 1;
                    nowheight = matrix[i][1];
                }
            }
        }

        System.out.println(sum);
    }
}