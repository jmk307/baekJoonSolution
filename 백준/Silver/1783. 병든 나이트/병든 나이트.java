import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[][] matrix;
    static int[] linear, replace;
    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (N == 1) answer = 1;
        if (N == 2) answer = Math.min(4, (M + 1) / 2);
        if (N >= 3) {
            if (M >= 7) {
                answer = M - 2;
            } else {
                answer = Math.min(4, M);
            }
        }

        System.out.println(answer);
    }
}