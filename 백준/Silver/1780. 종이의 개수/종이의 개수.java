import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[][] matrix;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][N];
        result = new int[3];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        divideAndConquer(0, 0, N);
        
        for (int i : result) {
            System.out.println(i);
        }
    }
    
    static void divideAndConquer(int a, int b, int size) {
        if (size == 0) {
            return;
        }
        
        boolean isSame = true;
        int start = matrix[a][b];
        
        for (int i = b; i < b + size; i++) {
            for (int j = a; j < a + size; j++) {
                if (matrix[j][i] != start) {
                    isSame = false;
                    break;
                }
            }
        }
        
        int x = size / 3;
        if (isSame) {
            if (start == -1) {
                result[0] += 1;
            } else if (start == 0) {
                result[1] += 1;
            } else {
                result[2] += 1;
            }
        } else {
            divideAndConquer(a, b, x);
            divideAndConquer(a + x, b, x);
            divideAndConquer(a + 2*x, b, x);
            divideAndConquer(a, b + x, x);
            divideAndConquer(a + x, b + x, x);
            divideAndConquer(a + 2*x, b + x, x);
            divideAndConquer(a, b + 2*x, x);
            divideAndConquer(a + x, b + 2*x, x);
            divideAndConquer(a + 2*x, b + 2*x, x);
        }
    }
}