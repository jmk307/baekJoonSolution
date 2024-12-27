import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static String[] S, T;

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

        S = br.readLine().split("");
        T = br.readLine().split("");

        for (int i = T.length - 1; i > S.length - 1; i--) {
            if (T[i].equals("A")) {
                T[i] = "";
            } else {
                T[i] = "";

                int start = 0;
                int end = i - 1;

                while (start <= end) {
                    String a = T[start];
                    String temp = a;
                    String b = T[end];

                    T[start] = b;
                    T[end] = temp;

                    start++;
                    end--;
                }
            }
        }

        String A = "";
        for (String i : S) {
            A += i;
        }

        String B = "";
        for (String i : T) {
            B += i;
        }

        if (A.equals(B)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}