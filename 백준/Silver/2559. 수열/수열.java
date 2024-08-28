import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)   {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            max += matrix[i];
        }
        currentSum = max;
        currentSum -= matrix[0];

        for (int i = 1; i < N - K + 1; i++) {
            currentSum += matrix[i + K - 1];
            max = Math.max(max, currentSum);
            currentSum -= matrix[i];
        }

        System.out.println(max);
    }
}