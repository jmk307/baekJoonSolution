import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, K, S, X, Y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now % 2 == 1) {
                list.add(now);
                sum += now;
            }
        }
        Collections.sort(list);

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
}