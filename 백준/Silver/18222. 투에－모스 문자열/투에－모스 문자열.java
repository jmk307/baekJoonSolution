import java.util.*;
import java.io.*;

public class Main {
    static long k;
    
    static long[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        k = Long.parseLong(br.readLine());

        matrix = new long[64];
        matrix[0] = 1;
        for (int i = 1; i < 64; i++){
            matrix[i] = matrix[i-1] * 2;
        }
        System.out.println(divideAndConquer(k));
    }
    
    static long divideAndConquer(long v) {
        if (v == 1) return 0;
        for (int i = 0; i < 64; i++){
            if (matrix[i] >= v) return 1 - divideAndConquer(v - matrix[i-1]);
        }
        return 0;
    }
}
