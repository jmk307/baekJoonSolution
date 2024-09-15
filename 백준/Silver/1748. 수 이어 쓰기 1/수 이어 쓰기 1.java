import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String N;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = br.readLine();
        
        int length = N.length();
        int sum = 0;
        int current = Integer.parseInt(N);
        sum += length * (current - Math.pow(10, length - 1) + 1);
        
        length--;
        while (true) {
            if (length == 0) {
                break;
            }
            
            sum += length * 9 * Math.pow(10, length - 1);
            length--;
        }
        
        System.out.println(sum);
    }
}