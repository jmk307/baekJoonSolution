import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static Long N;
    static int count = 0;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Long.parseLong(br.readLine());
        
        int current = 1;
        while (true) {
            if (N <= 0) {
                break;
            }
            
            N -= current;
            current++;
        }
        
        if (N == 0) {
            System.out.println(current - 1);
        } else {
            System.out.println(current - 2);
        }
    }
}