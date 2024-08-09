import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[] matrix;
    static int[] fruits = new int[10];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(0, 0, 0,0, 0));
    }

    static int twoPointer(int left, int right, int count, int kind, int max) {
        if (right >= N) {
            return max;
        }

        if (fruits[matrix[right]] == 0) {
            kind++;
        }

        count++;
        fruits[matrix[right]]++;

        if (kind > 2) {
            if (--fruits[matrix[left]] == 0) {
                kind--;
            }
            count--;
            left++;
        }

        max = Math.max(max, count);

        return twoPointer(left, right + 1, count, kind, max);
    }
}