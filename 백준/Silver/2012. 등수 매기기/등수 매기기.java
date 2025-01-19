import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static long sum = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix, replace;
    static List<Long> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list);

        for (int i = N - 1; i >= 0; i--) {
            sum += Math.abs(i + 1 - list.get(i));
        }

        System.out.println(sum);
    }
}