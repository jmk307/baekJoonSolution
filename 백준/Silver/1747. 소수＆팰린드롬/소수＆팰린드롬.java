import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static boolean[] isPrime = new boolean[100000001];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= 100000000; i++) {
		    isPrime[i] = true;
		}
		
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i <= Math.sqrt(100000000); i++) {
		    if (isPrime[i]) {
		        for (int j = i * i; j <= 100000000; j+=i) {
		            isPrime[j] = false;
		        }
		    }
		}
		
		for (int i = N; i <= 100000000; i++) {
		    if (isPrime[i]) {
		        String[] now = String.valueOf(i).split("");
		        
		        int start = 0;
		        int end = now.length - 1;
		        
		        boolean isAnswer = true;
		        while (start <= end) {
		            if (!now[start].equals(now[end])) {
		                isAnswer = false;
		                break;
		            }
		            
		            start++;
		            end--;
		        }
		        
		        if (isAnswer) {
		            System.out.println(i);
		            break;
		        }
		    }
		}
	}
}
