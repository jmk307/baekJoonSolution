import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int current = matrix[i];

            if (current == M) {
                count++;
            }
            for (int j = i + 1; j < N; j++) {
                current += matrix[j];

                if (current == M) {
                    count++;

                    break;
                }
            }
        }

        System.out.println(count);
    }
}