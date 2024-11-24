import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static int[] result;
    static boolean[] visited = new boolean[26];

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        matrix = new int[10];
        result = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);

        System.out.println(count);
    }

    static void backTracking(int depth, int sum) {
        if (depth == 10) {
            if (sum >= 5) {
                count++;
            }

            return;
        }


        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && result[depth-1] == i && result[depth-2] == i) {
                continue;
            }

            result[depth] = i;

            if (result[depth] == matrix[depth]) {
                backTracking(depth + 1, sum + 1);
            } else {
                backTracking(depth + 1, sum);
            }
        }
    }
}