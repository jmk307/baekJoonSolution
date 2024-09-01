import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n;
    
    static boolean[] isPrime = new boolean[246913];
    static int[] S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        S = new int[246913];
        
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i < Math.sqrt(246913); i++) {
            for (int j = i * i; j <= 246913; j+=i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }
        
        S[0] = S[1] = 0;
        
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                S[i] = S[i - 1] + 1;
            } else {
                S[i] = S[i - 1];
            }
        }
        
        String input = "";
        while ((input = br.readLine()) != "0") {
            int current = Integer.parseInt(input);
            
            if (current == 0) {
                break;
            }
            
            System.out.println(S[2*current] - S[current]);
        }
    }
}