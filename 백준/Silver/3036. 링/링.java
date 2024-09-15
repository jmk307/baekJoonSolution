import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        int first = matrix[0];
        for (int i = 1; i < N; i++) {
            sb.append(first / gcd(first, matrix[i])).append("/").append(matrix[i] / gcd(first, matrix[i])).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}