import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String S;
    static int T, A, B;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		S = br.readLine();
		T = Integer.parseInt(br.readLine());
		
		String[] arrays = S.split("");
		
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            String a = arrays[A];
            String b = arrays[B];
            
            arrays[A] = b;
            arrays[B] = a;
        }
        
        String answer = "";
        for (String i : arrays) {
            answer += i;
        }
        
        System.out.println(answer);
	}
}
