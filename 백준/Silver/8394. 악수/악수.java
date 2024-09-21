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
        
        if (n <= 3) {
            dp = new int[4];
            
            dp[1] = 0;
            dp[2] = 2;
            dp[3] = 3;
            
            System.out.println(dp[n]);
        } else {
            dp = new int[n + 1];
            
            dp[1] = 0;
            dp[2] = 2;
            dp[3] = 3;
            
            for (int i = 4; i <= n; i++) {
                int current = dp[i-1] + dp[i-2];
                
                if (current >= 10) {
                    current %= 10;
                }
                
                dp[i] = current;
            }
            
            System.out.println(dp[n]);
        }
    }
}