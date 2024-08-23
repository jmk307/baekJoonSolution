import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, n;
    
    static boolean[] isPrime;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            n = Integer.parseInt(br.readLine());
            
            isPrime = new boolean[n + 1];
        
            for (int i = 0; i < isPrime.length; i++) {
                isPrime[i] = true;
            }
            
            isPrime[0] = isPrime[1] = false;
            
            for (int i = 2; i <= Math.sqrt(n); i++) {
                for (int j = i * i; j <= n; j+=i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                    }
                }
            }
            
            for (int i = n / 2; i >= 0; i--) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.print(i);
                    System.out.print(" ");
                    System.out.print(n - i);
                    System.out.println();
                    break;
                }
            }
            
        }
    }
}