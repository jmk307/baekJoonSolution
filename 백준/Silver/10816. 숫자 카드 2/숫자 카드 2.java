import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        matrix = new int[N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int startIndex = frontIndexBinarySearch(target);
            int lastIndex = lastIndexBinarySearch(target);

            int len = lastIndex - startIndex + 1;

            sb.append(len).append(" ");
        }

        System.out.println(sb);
    }

    static int frontIndexBinarySearch(int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int midi = (start + end) / 2;
            int midv = matrix[midi];

            if (midv < target) {
                start = midi + 1;
            } else {
                end = midi - 1;
            }
        }
        return start;
    }

    static int lastIndexBinarySearch(int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int midi = (start + end) / 2;
            int midv = matrix[midi];

            if (midv <= target) {
                start = midi + 1;
            } else {
                end = midi - 1;
            }
        }
        return end;
    }
}