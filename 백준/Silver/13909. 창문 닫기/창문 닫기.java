import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static long N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Long.parseLong(br.readLine());

        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            count++;
        }

        System.out.println(count);
    }
}