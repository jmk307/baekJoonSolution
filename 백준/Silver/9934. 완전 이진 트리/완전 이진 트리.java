import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int K;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        matrix = new int[(int) Math.pow(2, K)];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < (int) Math.pow(2, K); i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = (int) Math.pow(2, K-1); i > 0; i /= 2) {
            for (int j = i; j <= (int) Math.pow(2, K) - 1; j += 2*i) {
                sb.append(matrix[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}