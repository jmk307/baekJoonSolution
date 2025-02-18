import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static String answer = "";

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static String[] matrix;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static List<Integer> total = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N + 1];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            matrix[i] = br.readLine();
            next[i] = i;
            tail[i] = i;
        }

        int index = 0;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            next[tail[a]] = b;
            tail[a] = tail[b];

            index = a;
        }

        for (int i = 0; i < N; i++) {
            sb.append(matrix[index]);
            index = next[index];
        }

        System.out.println(sb);
    }
}