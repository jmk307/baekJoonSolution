import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String A, B;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        
        String[] a = A.split("");
        String[] b = B.split("");
        
        int x = 0;
        int y = 0;

        A = "";
        for (int i = 2; i >= 0; i--) {
            A += a[i];
        }
        x = Integer.parseInt(A);
        
        B = "";
        for (int i = 2; i >= 0; i--) {
            B += b[i];
        }
        y = Integer.parseInt(B);
        
        System.out.println(Math.max(x, y));
    }
}