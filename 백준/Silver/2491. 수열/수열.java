import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] matrix, dp;

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

        dp = new int[N];

        int increasingMax = 0;
        int max1 = 1;
        dp[0] = 1;
        for (int j = 1; j < matrix.length; j++) {
            if (matrix[j] >= matrix[j-1]) {
                dp[j] = dp[j-1] + 1;
            } else {
                dp[j] = 1;
            }

            max1 = Math.max(max1, dp[j]);
        }
        increasingMax = Math.max(max1, increasingMax);

        int decreasingMax = 0;
        int max2 = 1;
        dp[0] = 1;
        for (int j = 1; j < matrix.length; j++) {
            if (matrix[j] <= matrix[j-1]) {
                dp[j] = dp[j-1] + 1;
            } else {
                dp[j] = 1;
            }

            max2 = Math.max(max2, dp[j]);
        }
        decreasingMax = Math.max(max2, decreasingMax);

        int answer = Math.max(increasingMax, decreasingMax);

        System.out.println(answer);
    }
}