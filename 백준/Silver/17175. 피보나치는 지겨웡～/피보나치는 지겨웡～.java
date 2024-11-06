import java.util.*;
import java.io.*;

public class Main {
    static int n, count;
    
    static int[] dp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        
        dp[0] = 1;
        if (n == 0) {
            System.out.println(dp[n] % 1000000007);
        } else {
            dp[1] = 1;
        
            fibonacci(n);
            System.out.println(dp[n] % 1000000007);
        }
    }
    
    static int fibonacci(int n) {
        if (n < 2) {
            return dp[n] % 1000000007;
        }
        
        if (dp[n] != 0) {
            return dp[n] % 1000000007;
        } else {
            return dp[n] = (fibonacci(n-2) + fibonacci(n-1) + 1) % 1000000007;
        }
    }
}
