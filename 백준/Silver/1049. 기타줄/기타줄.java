import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int minX = 1001;
        int minY = 1001;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            
            minX = Math.min(minX, X);
            minY = Math.min(minY, Y);
        }
        
        int minPrice = Integer.MAX_VALUE;
        for (int i = (int) Math.ceil((double) N / 6.0); i >= 0; i--) {
            int current = 0;
            if (6 * i >= N) {
                current = minX * i;
            } else {
                current = minX * i + minY * (N - 6*i);
            }
            
            minPrice = Math.min(minPrice, current);
        }
        
        System.out.println(minPrice);
    }
}