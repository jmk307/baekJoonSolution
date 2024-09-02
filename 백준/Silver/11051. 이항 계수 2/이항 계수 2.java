import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;
    
    static int[][] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dp = new int[N + 1][K + 1];
        
        System.out.println(comb(N, K) % 10007);
    }
    
    static int comb(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        
        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }
        
        return dp[n][k] = comb(n-1, k) % 10007 + comb(n-1, k-1) % 10007;
    }
}