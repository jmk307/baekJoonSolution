import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int[] matrix;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		matrix = new int[6];
		matrix[0] = 1;
		matrix[1] = 1;
		matrix[2] = 2;
		matrix[3] = 2;
		matrix[4] = 2;
		matrix[5] = 8;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
		    int result = matrix[i] - Integer.parseInt(st.nextToken());
		    sb.append(result).append(" ");
		}
		
		System.out.println(sb);
	}
}