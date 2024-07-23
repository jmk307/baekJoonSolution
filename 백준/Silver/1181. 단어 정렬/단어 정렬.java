import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[] matrix = new String[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine();
        }

        matrix = Arrays.stream(matrix).distinct().toArray(String[]::new);

        Arrays.sort(matrix, (e1, e2) -> {
            if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
            } else {
                return e1.length() - e2.length();
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }
    }
}