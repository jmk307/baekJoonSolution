import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        
        for (int i = 5; i <= N; i++) {
            if (dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        
        if (dp[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}