import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix, light;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static List<Integer> total = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;

        matrix = new int[N];
        light = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, matrix[i]);
        }

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            light[i] = Integer.parseInt(st.nextToken());

            if (light[i] == 1) {
                result += matrix[i];
            }
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (light[i] == 0) {
                sum += matrix[i];
            } else {
                sum -= matrix[i];
            }

            if (sum < 0) {
                sum = 0;
            }

            max = Math.max(max, sum);
        }

        if (max == 0) {
            System.out.println(result - min);
        } else {
            System.out.println(result + max);
        }
    }
}