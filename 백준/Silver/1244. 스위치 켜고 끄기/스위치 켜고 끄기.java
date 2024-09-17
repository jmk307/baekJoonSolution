import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, T;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            
            int sex = Integer.parseInt(st.nextToken());
            int current = Integer.parseInt(st.nextToken());
            
            if (sex == 1) {
                for (int i = current; i <= N; i += current) {
                    if (matrix[i] == 1) {
                        matrix[i] = 0;
                    } else if (matrix[i] == 0) {
                        matrix[i] = 1;
                    }
                }
            } else {
                int i = current;
                int j = 2 * current - i;
                
                while (true) {
                    if (i == 0 || 2 * current - i == N + 1) {
                        break;
                    }
                    
                    if (matrix[i] == matrix[2 * current - i]) {
                        if (matrix[i] == 1) {
                            matrix[i] = 0;
                            matrix[2 * current - i] = 0;
                        } else if (matrix[i] == 0) {
                            matrix[i] = 1;
                            matrix[2 * current - i] = 1;
                        }
                    } else {
                        break;
                    }
                    
                    i--;
                }
            }
        }
        
        if (N < 21) {
            for (int i = 1; i <= N; i++) {
                sb.append(matrix[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N / 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    sb.append(matrix[20 * i + j]).append(" ");
                }
                sb.append("\n");
            }
            
            for (int i = 20 * (N / 20) + 1; i <= N; i++) {
                sb.append(matrix[i]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}