import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, S;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[] matrix;
    static int[][][] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        if (T >= 12 && T <= 16 && S == 0) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
    }
}