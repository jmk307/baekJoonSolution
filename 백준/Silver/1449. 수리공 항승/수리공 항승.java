import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, L;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        matrix = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix);
        
        int start = matrix[0];
        int count = 1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i + 1] >= start + L) {
                start = matrix[i + 1];
                count++;
            }
        }
        
        System.out.println(count);
    }
}