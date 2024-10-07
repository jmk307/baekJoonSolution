import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, X;

    static int[] matrix;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        matrix = new int[N];
        answer = new int[N-X+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += matrix[i];
        }

        max = sum;
        answer[0] = sum;
        sum -= matrix[0];
        for (int i = 1; i < N - X + 1; i++) {
            sum += matrix[i + X - 1];
            answer[i] = sum;
            max = Math.max(max, sum);
            sum -= matrix[i];
        }

        int count = 0;
        for (int i : answer) {
            if (i == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}