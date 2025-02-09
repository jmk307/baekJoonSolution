import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int A, B, C;
    static int min = 1000 * 1000;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] food;
    static int[][] dp;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] input = br.readLine().toCharArray();

        int count = 0;
        for (char i : input) {
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                count++;
            }
        }

        System.out.println(count);
    }
}