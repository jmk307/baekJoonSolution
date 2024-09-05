import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		List<Integer> helmets = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    helmets.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> vests = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
		    vests.add(Integer.parseInt(st.nextToken()));
		}
        
        System.out.println(Collections.max(helmets) + Collections.max(vests));
	}
}
