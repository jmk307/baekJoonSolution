import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, K;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static List<Integer> gap = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        if (K >= N) {
            System.out.println(0);
        } else {
            matrix = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                matrix[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(matrix);

            for (int i = N - 1; i >= 1; i--) {
                gap.add(matrix[i] - matrix[i-1]);
            }
            Collections.sort(gap, Collections.reverseOrder());

            int total = matrix[N-1] - matrix[0];

            for (int i = 0; i < K - 1; i++) {
                total -= gap.get(i);
            }

            System.out.println(total);
        }
    }
}