import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    static int[] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean isFind = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = matrix.length - 1;

            while (start <= end) {
                int midi = (start + end) / 2;
                int midv = matrix[midi];

                if (midv > target) {
                    end = midi - 1;
                } else if (midv < target) {
                    start = midi + 1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}