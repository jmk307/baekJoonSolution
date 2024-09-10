import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String A, B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        
        String[] a = A.split("");
        String[] b = B.split("");
        
        int k = B.length() - A.length();
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int x = 0;
            for (int j = 0; j < a.length; j++) {
                if (!a[j].equals(b[j + i])) {
                    x++;
                }
            }
            
            answer = Math.min(answer, x);
        }
        
        System.out.println(answer);
    }
}