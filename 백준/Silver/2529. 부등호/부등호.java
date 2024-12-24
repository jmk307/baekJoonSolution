import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int k;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static String minString = "";
    static String maxString = "";

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] calc;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        calc = new int[k];
        result = new int[k + 1];
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            if (st.nextToken().equals("<")) {
                calc[i] = 0;
            } else {
                calc[i] = 1;
            }
        }

        backTracking(0);

        System.out.println(maxString);
        System.out.println(minString);
    }

    static void backTracking(int depth) {
        if (depth == k + 1) {
            String total = "";
            for (int i = 0; i < k + 1; i++) {
                total += String.valueOf(result[i]);
            }

            min = Math.min(min, Long.parseLong(total));
            max = Math.max(max, Long.parseLong(total));

            if (min == Long.parseLong(total)) {
                minString = total;
            }

            if (max == Long.parseLong(total)) {
                maxString = total;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth > 0 && !visited[i]) {
                if (calc[depth-1] == 0 && result[depth-1] < i) {
                    visited[i] = true;
                    result[depth] = i;
                    backTracking(depth + 1);
                    visited[i] = false;
                } else if (calc[depth-1] == 1 && result[depth-1] > i) {
                    visited[i] = true;
                    result[depth] = i;
                    backTracking(depth + 1);
                    visited[i] = false;
                }
            } else {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = i;
                    backTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}