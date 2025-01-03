import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int K;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static int[][] matrix = new int[5][8];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 5; i++) {
            String[] arrays = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = Integer.parseInt(arrays[j]);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            int[] result = new int[5];
            result[target] = direction;

            for (int j = target + 1; j <= 4; j++){
                if (matrix[j][6] != matrix[j-1][2]) {
                    result[j] = result[j-1] * -1;
                } else {
                    result[j] = 0;
                }
            }

            for (int j = target - 1; j >= 1; j--) {
                if (matrix[j][2] != matrix[j+1][6]) {
                    result[j] = result[j+1] * -1;
                } else {
                    result[j] = 0;
                }
            }

            for (int j = 1; j < 5; j++) {
                int[] now = matrix[j];
                int[] replace = new int[8];

                if (result[j] == 1) {
                    for (int k = 0; k < 7; k++) {
                        replace[k+1] = now[k];
                    }
                    replace[0] = now[7];

                    for (int k = 0; k < 8; k++) {
                        matrix[j][k] = replace[k];
                    }
                } else if (result[j] == -1) {
                    for (int k = 1; k < 8; k++) {
                        replace[k-1] = now[k];
                    }
                    replace[7] = now[0];

                    for (int k = 0; k < 8; k++) {
                        matrix[j][k] = replace[k];
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            if (matrix[i][0] == 1) {
                sum += (int) Math.pow(2, i-1);
            }
        }

        System.out.println(sum);
    }
}