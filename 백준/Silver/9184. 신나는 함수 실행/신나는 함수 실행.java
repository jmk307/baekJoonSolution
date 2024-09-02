import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B, C;
    
    static long[][][] dp = new long[51][51][51];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if (A == -1 && B == -1 && C == -1) {
                break;
            }
            
            if (A <= 0 || B <= 0 || C <= 0) {
                sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(")")
                    .append(" = ").append(1).append("\n");
            } else {
                w(A, B, C);
                sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(")")
                    .append(" = ").append(dp[A][B][C]).append("\n");
            }
        }
        
        System.out.println(sb);
    }
    
    static long w(int a, int b, int c) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[a][b][c] = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[a][b][c] = w(20, 20, 20);
        } else if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}