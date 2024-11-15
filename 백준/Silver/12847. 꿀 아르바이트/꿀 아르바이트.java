import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        matrix = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += matrix[i];
        }
        long max = sum;
        
        for (int i = 1; i <= n - m; i++) {
            sum -= matrix[i-1];
            sum += matrix[i + m - 1];
            
            max = Math.max(sum, max);
        }
        
        System.out.println(max);
    }
}
