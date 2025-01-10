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

    static int[] matrix;
    static int[][][] dp;
    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] arrays = br.readLine().split("");
            String now = "";

            for (String j : arrays) {
                now += j;
                map.put(now, 0);
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}