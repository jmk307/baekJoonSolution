import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, d, s;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] matrix, replace;
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());

        int answer = -1;
        for (int i = 0; i < N - 2; i++) {
            if (list.get(i) < list.get(i + 1) + list.get(i + 2)) {
                answer = Math.max(answer, list.get(i) + list.get(i + 1) + list.get(i + 2));
            }
        }

        System.out.println(answer);
    }
}