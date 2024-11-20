import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int n;
    static int count = 0;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        matrix = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, matrix[i]);

            if (max == matrix[i]) {
                index = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != index) {
                sum += matrix[i] + max;
            }
        }

        System.out.println(sum);
    }
}