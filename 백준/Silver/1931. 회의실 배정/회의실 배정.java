import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            matrix[i][0] = start;
            matrix[i][1] = end;
        }
        
        Arrays.sort(matrix, (e1, e2) -> {
           if (e1[1] == e2[1]) {
               return e1[0] - e2[0];
           } else {
               return e1[1] - e2[1];
           }
        });
        
        int depth = 0;
        int currentIndex = 0;
        for (int i = 1; i < N; i++) {
            if (matrix[currentIndex][1] <= matrix[i][0]) {
                currentIndex = i;
                depth++;
            }
        }
        
        System.out.println(depth + 1);
    }
}