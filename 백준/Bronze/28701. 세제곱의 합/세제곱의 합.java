import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        long a = 0;
        for (int i = 1; i <= N; i++) {
            a += i;
        }

        long b = (long) Math.pow(a, 2);

        long c = 0;
        for (int i = 1; i <= N; i++) {
            c += (long) Math.pow(i, 3);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}