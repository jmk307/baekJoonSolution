import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b;
    
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        matrix = new int[9];
        
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
            sum += matrix[i];
        }
        Arrays.sort(matrix);
        
        int target = sum - 100;
        
        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            int current = matrix[i];
            for (int j = i + 1; j < 9; j++) {
                if (current + matrix[j] == target) {
                    a = current;
                    b = matrix[j];
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i : matrix) {
            if (i != a && i != b) {
                System.out.println(i);
            }
        }
    }
}