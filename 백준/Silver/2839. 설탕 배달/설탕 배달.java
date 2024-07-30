import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        N = Integer.parseInt(br.readLine());

        int[] matrix = new int[5001];
        matrix[3] = 1;
        matrix[4] = -1;
        matrix[5] = 1;
        matrix[6] = 2;
        matrix[7] = -1;
        
        for (int i = 8; i < 5001; i++) {
            if (matrix[i - 5] == -1) {
                matrix[i] = matrix[3] + matrix[i - 3];
            } else {
                 matrix[i] = matrix[5] + matrix[i - 5];
            }
        }
        
        System.out.println(matrix[N]);
    }
}