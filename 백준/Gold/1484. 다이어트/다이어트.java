import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int G;
    static int answer = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static long[][] dp;
    static int[][] matrix;
    static boolean[][][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        G = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(G); i++) {
            if (G % i == 0) {
                int a = i;
                int b = G / i;

                if ((a + b) % 2 == 0 && (a - b) != 0) {
                    list.add((a + b) / 2);
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        }
    }
}