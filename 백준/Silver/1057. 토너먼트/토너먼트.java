import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K, L;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int round = 0;
		while (K != L) {
			K = K / 2 + K % 2;
			L = L / 2 + L % 2;
			round++;
		}
		
		System.out.println(round);
    }
}