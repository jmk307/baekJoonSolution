import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static String[] S;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static long[][] dp;
    static List<Integer> list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine().split("");

        dp = new long[5001][3];

        if (S.length == 1) {
            if (S[0].equals("0")) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else {
            if (Integer.parseInt(S[0]) != 0) {
                dp[1][1] = 1;
            }
            dp[1][2] = 0;

            if (Integer.parseInt(S[1]) != 0) {
                dp[2][1] += (dp[1][1] % 1000000 + dp[1][2] % 1000000) % 1000000;
            }

            String current = "";
            for (int i = 0; i < 2; i++) {
                current += S[i];
            }

            if (Integer.parseInt(current) >= 1 && Integer.parseInt(current) <= 26 && current.charAt(0) != '0') {
                dp[2][2] = 1;
            }

            for (int i = 3; i <= S.length; i++) {
                if (Integer.parseInt(S[i-1]) != 0) {
                    dp[i][1] += (dp[i-1][1] % 1000000 + dp[i-1][2] % 1000000) % 1000000;
                }

                current = "";
                for (int j = i - 2; j < i; j++) {
                    current += S[j];
                }

                if (Integer.parseInt(current) >= 1 && Integer.parseInt(current) <= 26 && current.charAt(0) != '0') {
                    dp[i][2] += (dp[i-2][1] % 1000000 + dp[i-2][2] % 1000000) % 1000000;
                }
            }

            System.out.println((dp[S.length][1] % 1000000 + dp[S.length][2] % 1000000) % 1000000);
        }
    }
}