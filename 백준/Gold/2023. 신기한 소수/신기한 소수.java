import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix = {1, 3, 7, 9};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        DFS(0, "2");
        DFS(0, "3");
        DFS(0, "5");
        DFS(0, "7");
    }

    static boolean isPrime(String x) {
        for (int i = 2; i * i <= Integer.parseInt(x); i++) {
            if (Integer.parseInt(x) % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    static void DFS(int depth, String current) {
        if (depth == N - 1) {
            if (isPrime(current)) {
                System.out.println(current);
            }
            
            return;
        }
        
        if (isPrime(current)) {
            for (int i = 0; i < 4; i++) {
                DFS(depth + 1, current + String.valueOf(matrix[i]));
            }
        }
    }
}