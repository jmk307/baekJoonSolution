import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, T;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] matrix = new int[5];

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
            sum += matrix[i]
;        }
        Arrays.sort(matrix);

        System.out.println(sum / 5);
        System.out.println(matrix[2]);
    }
}