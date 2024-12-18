import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
            sum += matrix[i];
            max = Math.max(max, matrix[i]);
        }

        int start = max;
        int end = sum;

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 1;
            int current = mid;
            for (int i : matrix) {
                current -= i;
                
                if (current < 0) {
                    count++;
                    current = mid - i;
                }
            }

            if (M >= count) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}