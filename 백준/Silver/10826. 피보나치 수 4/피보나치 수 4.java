import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int n;

    static BigInteger[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new BigInteger[n + 1];

        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            dp[1] = BigInteger.ONE;
            dp[2] = BigInteger.ONE;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1].add(dp[i-2]);
            }
            System.out.println(dp[n]);
        }
    }
}