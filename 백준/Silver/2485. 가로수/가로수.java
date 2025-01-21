import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static long[] matrix;
    static boolean[] visited;
    static List<Long> list = new ArrayList<>();
    static Map<Long, String> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new long[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            list.add(matrix[i] - matrix[i-1]);
        }
        Collections.sort(list);

        long min = Long.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, gcd(list.get(0), list.get(i)));
        }

        long total = (matrix[N-1] - matrix[0]) / min + 1;

        System.out.println(total - N);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}