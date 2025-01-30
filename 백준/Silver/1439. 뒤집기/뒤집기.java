import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, E;
    static String S;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();

        int count = 0;
        int prev = S.charAt(0);

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != prev && S.charAt(i-1) == prev) {
                count++;
            }
        }

        System.out.println(count);
    }
}