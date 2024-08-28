import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static long[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        dp = new long[1000001];
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        
        System.out.println(dp[N] % 15746L);
    }
}