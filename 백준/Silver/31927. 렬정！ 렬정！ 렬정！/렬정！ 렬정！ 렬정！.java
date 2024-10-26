import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);

            for (int i : matrix) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {

            int count = N / 2;
            for (int i = 0; i < N / 2; i++) {

                matrix[i] += count * 5000;
                matrix[N - i - 1] -= count * 5000;

                for (int j : matrix) {
                    sb.append(j).append(" ");
                }
                sb.append("\n");

                count--;
            }
            System.out.println(N / 2);
            System.out.println(sb);
        }
    }
}