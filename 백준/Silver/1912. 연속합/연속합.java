import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n;
    
    static int[] matrix;
    static int[] dp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        matrix = new int[n];
        dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = matrix[0];
        dp[0] = matrix[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + matrix[i], matrix[i]);
            
            max = Math.max(dp[i], max);
        }
        
        System.out.println(max);
    }
}