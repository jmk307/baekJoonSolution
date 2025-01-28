import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, C;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[] matrix;
    static boolean[][] visited;
    static List<int[]> clowns = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(matrix);

        int start = 0;
        int end = matrix[N-1] - matrix[0] + 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            int count = 1;
            int prev = matrix[0];

            for (int i = 1; i < N; i++) {
                if (matrix[i] - prev >= mid) {
                    count++;
                    prev = matrix[i];
                }
            }

            if (count < C) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(start);
    }
}