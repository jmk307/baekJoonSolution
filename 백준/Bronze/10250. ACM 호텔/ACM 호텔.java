import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, H, W, N;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            matrix = new int[W + 1][H + 1];

            int currentI = 1;
            int x = 0;
            int y = 0;
            for (int i = 1; i < H + 1; i++) {
                currentI = i;
                for (int j = 1; j < W + 1; j++) {
                    matrix[j][i] += currentI;
                    if (matrix[j][i] == N) {
                        x = i;
                        y = j;
                        break;
                    }

                    currentI += H;
                }
            }

            if (y < 10) {
                String a = String.valueOf(x);
                String b = "0" + y;

                System.out.println(a + b);
            } else {
                String a = String.valueOf(x);
                String b = String.valueOf(y);

                System.out.println(a + b);
            }
        }
    }
}