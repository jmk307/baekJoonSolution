import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;
    static int count = 0;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            matrix[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (matrix[i] == matrix[col]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(matrix[col] - matrix[i])) {
                return false;
            }
        }

        return true;
    }
}