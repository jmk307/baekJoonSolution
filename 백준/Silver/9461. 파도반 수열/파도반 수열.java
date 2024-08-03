import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int T, N;
    
    static long[] matrix;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            matrix = new long[101];
            matrix[1] = 1L;
            matrix[2] = 1L;
            matrix[3] = 1L;
            matrix[4] = 2L;
            matrix[5] = 2L;
            
            for (int j = 6; j < N + 1; j++) {
                matrix[j] = matrix[j-1] + matrix[j-5];
            }
            
            System.out.println(matrix[N]);
        }
    }
}