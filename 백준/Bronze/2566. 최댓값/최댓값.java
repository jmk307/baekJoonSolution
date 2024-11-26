import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix = new int[10][10];
    static int[] result;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int[] answer = new int[2];
        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, matrix[i][j]);

                if (max == matrix[i][j]) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        System.out.println(max);
        System.out.print(answer[0]);
        System.out.print(" ");
        System.out.print(answer[1]);
    }
}