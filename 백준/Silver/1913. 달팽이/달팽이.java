import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static int[][] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        matrix = new int[N][N];
        
        divideAndConquer(0, 0, N, N*N);
        
        int answerX = 0;
        int answerY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int current = matrix[j][i];
                
                if (current == M) {
                    answerX = j + 1;
                    answerY = i + 1;
                }
                
                sb.append(current).append(" ");
            }
            sb.append("\n");
        }
        
        sb.append(answerY).append(" ").append(answerX);
        
        System.out.println(sb);
    }
    
    static void divideAndConquer(int a, int b, int size, int c) {
        if (size == 1) {
            matrix[N/2][N/2] = 1;
            return;
        }
        
        int current = c;
        
        for (int i = b; i < b + size - 1; i++) {
            matrix[a][i] = current;
            current--;
        }
        
        for (int i = a; i < a + size - 1; i++) {
            matrix[i][b + size - 1] = current;
            current--;
        }
        
        for (int i = b + size - 1; i > b; i--) {
            matrix[a + size - 1][i] = current;
            current--;
        }
        
        for (int i = a + size - 1; i > a; i--) {
            matrix[i][b] = current;
            current--;
        }
        
        divideAndConquer(a + 1, b + 1, size - 2, current);
    }
}