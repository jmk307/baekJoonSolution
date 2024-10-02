import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static String[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            String A = matrix[i];

            for (int j = i + 1; j < N; j++) {
                String B = matrix[j];

                int min = Math.min(A.length(), B.length());

                for (int k = 1; k <= min; k++) {
                    if (A.substring(0, k).equals(B.substring(B.length() - k))) {
                        count++;
                        break;
                    } else if (A.substring(A.length() - k).equals(B.substring(0, k))) {
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}