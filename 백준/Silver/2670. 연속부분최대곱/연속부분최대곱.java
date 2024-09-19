import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static double[] matrix, dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new double[N];
        dp = new double[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = matrix[0];

        double max = 0.0;
        for (int i = 1; i < matrix.length; i++) {
            dp[i] = Math.max(dp[i-1] * matrix[i], matrix[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));
    }
}