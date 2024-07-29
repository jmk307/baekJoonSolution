import java.lang.*;
import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[] matrix;
    static int[] bundle = new int[2];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        bundle[0] = Integer.parseInt(st.nextToken());
        bundle[1] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            if (matrix[i] % bundle[0] == 0) {
                sum += matrix[i] / bundle[0];
            } else {
                sum += (matrix[i] / bundle[0]) + 1;
            }
        }

        sb.append(sum).append("\n");
        sb.append(N / bundle[1]).append(" ").append(N % bundle[1]);

        System.out.println(sb);
    }
}