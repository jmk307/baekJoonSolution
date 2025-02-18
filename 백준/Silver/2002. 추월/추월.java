import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static String[] matrix, matrix2;
    static boolean[] visited;
    static Map<String, Integer> map = new LinkedHashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N];
        matrix2 = new String[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine();
            map.put(matrix[i], i);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            String now = br.readLine();

            for (String j : map.keySet()) {
                if (map.get(now) > map.get(j)) {
                    count++;
                    break;
                }
            }

            map.remove(now);
        }

        System.out.println(count);
    }
}