import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int max = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        System.out.println(N - 1946);
    }
}