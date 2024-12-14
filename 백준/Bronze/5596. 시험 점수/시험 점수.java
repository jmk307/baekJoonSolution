import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, m, a, b;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = 0;
        int b = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            a += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            b += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(a, b));
    }
}