import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b, q, t, k;
    static int count = 0;
    
    static int[] matrix;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            matrix[a]++;
            matrix[b]++;
        }
        
        q = Integer.parseInt(br.readLine());
        for (int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            
            t = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            if (t == 1) {
                if (matrix[k] == 1) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            } else {
                System.out.println("yes");
            }
        }
    }
}
