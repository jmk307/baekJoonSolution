import java.util.*;
import java.lang.*;
import java.io.*;

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

        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }

        Arrays.parallelSort(matrix);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, matrix[i] * (N - i));
        }

        System.out.println(max);
    }
}