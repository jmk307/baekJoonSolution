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

        List<Integer> W = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            W.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(W, Collections.reverseOrder());

        List<Integer> K = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            K.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(K, Collections.reverseOrder());

        int a = W.get(0) + W.get(1) + W.get(2);
        int b = K.get(0) + K.get(1) + K.get(2);

        System.out.println(a + " " + b);
    }
}