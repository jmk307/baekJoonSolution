import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b;
    
    static char[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        matrix = br.readLine().toCharArray();
        
        if (N == 1) {
            System.out.println(1);
        }  else {
            char prev = matrix[0];
            
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (matrix[i] != prev) {
                    count++;
                }
                
                prev = matrix[i];
            }
            
            System.out.println(count / 2 + 1);
        }
        
    }
}
