import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M, B;
    
    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        matrix = new int[M][N];
        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, matrix[j][i]);
                min = Math.min(min, matrix[j][i]);
            }
        }
        
        
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;
        while (true) {
            int inventory = B;
            int sum = 0;
            int currentHeight = max;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[j][i] > currentHeight) {
                        sum += 2 * (matrix[j][i] - currentHeight);
                        inventory += matrix[j][i] - currentHeight;
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[j][i] < currentHeight) {
                        sum += currentHeight - matrix[j][i];
                        inventory -= currentHeight - matrix[j][i];
                    }
                }
            }
            
            if (inventory >= 0) {
                if (sum < answerTime) {
                    answerTime = Math.min(sum, answerTime);
                    answerHeight = currentHeight;
                } else if (sum == answerTime) {
                    answerTime = sum;
                    answerHeight = Math.max(currentHeight, answerHeight);
                }
            }
            
            if (max == min) {
                break;
            }
            
            max--;
        }
        
        sb.append(answerTime).append(" ").append(answerHeight);
        
        System.out.println(sb);
    }
}