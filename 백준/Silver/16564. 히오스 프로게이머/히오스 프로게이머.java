import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    
    static long[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        matrix = new long[N];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(br.readLine());
            min = Math.min(min, matrix[i]);
        }
        
        long start = 1;
        long end = min + K + 1;
        
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            
            long count = 0;
            for (long i : matrix) {
                if (mid > i) {
                    count += mid - i;
                }
            }
            
            if (count > K) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        System.out.println(start);
    }
}
