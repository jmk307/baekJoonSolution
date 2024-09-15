import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N, M;
    
    static Integer[] A, B;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            
            A = new Integer[Integer.parseInt(st.nextToken())];
            B = new Integer[Integer.parseInt(st.nextToken())];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A, Collections.reverseOrder());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B, Collections.reverseOrder());
            
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                int current = A[i];
                
                int start = 0;
                int end = B.length - 1;
                
                while (start <= end) {
                    int midi = (start + end) / 2;
                    int midv = B[midi];
                    
                    if (current > midv) {
                        end = midi - 1;
                    } else {
                        start = midi + 1;
                    }
                }
                
                count += B.length - start;
            }
            
            System.out.println(count);
        }
    }
}