import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n;
    
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        if (n >= 0) {
            if (n == 0 || n == 1) {
                dp = new int[2];
                
                dp[1] = 1;
                
                if (dp[n] == 0) {
                    System.out.println(0);
                    System.out.println(0);
                } else {
                    System.out.println(1);
                    System.out.println(1);
                }
            } else {
                dp = new int[n + 1];
                
                dp[1] = 1;
                
                for (int i = 2; i <= n; i++) {
                    dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
                }
                
                System.out.println(1);
                System.out.println(dp[n] % 1000000000);
            }
        } else {
            if (n == -1) {
                System.out.println(1);
                System.out.println(1);
            } else {
                int N = (int) Math.abs(n);
                
                dp = new int[N + 1];
                
                dp[1] = 1;
                
                for (int i = 2; i <= N; i++) {
                    dp[i] = (dp[i-2] - dp[i-1]) % 1000000000;
                }
                
                if (dp[N] > 0) {
                    System.out.println(1);
                    System.out.println(dp[N] % 1000000000);
                } else if (dp[N] == 0) {
                    System.out.println(0);
                    System.out.println(dp[N] % 1000000000);
                } else {
                    System.out.println(-1);
                    System.out.println((int) Math.abs(dp[N] % 1000000000));
                }
            }
        }
    }
}