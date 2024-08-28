import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n, m;

    static BigInteger[][] dp = new BigInteger[101][101];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println(comb(n, m));
    }

    static BigInteger comb(int n, int m) {
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (m == 0 || n == m) {
            return dp[n][m] = BigInteger.ONE;
        }

        return dp[n][m] = comb(n - 1, m - 1).add(comb(n - 1, m));
    }
}