import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            
            System.out.println(lcm(a, b));
        }
    }
    
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}