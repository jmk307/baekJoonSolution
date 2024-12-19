import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int length = 1;
    static int count = 0;
    static long answer = -1;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if (N == 0) {
            answer = 0;
        } else {
            while (true) {
                if (answer != -1) {
                    break;
                }

                if (length == 11) {
                    break;
                }

                result = new int[length];
                backTracking(0, 10);
                length++;
            }
        }

        System.out.println(answer);
    }

    static void backTracking(int depth, int prev) {
        if (depth == length && result[0] != 0) {
            count++;

            if (count == N) {
                String total = "";
                for (int i = 0; i < length; i++) {
                    total += String.valueOf(result[i]);
                }

                answer = Long.parseLong(total);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (prev > matrix[i]) {
                result[depth] = matrix[i];
                backTracking(depth + 1, matrix[i]);
            }
        }
    }
}