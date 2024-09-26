import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static double A, B;
    
    static int[] matrix, answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        A = Double.parseDouble(br.readLine());
        
        System.out.println((int) Math.ceil(A / 5));
    }
}