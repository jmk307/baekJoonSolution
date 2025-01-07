import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int x, y;
	static long min = Integer.MAX_VALUE;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static long[] matrix;
	static long[] result;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
	    if (e1[0] == e2[0]) {
	        return e1[1] - e2[1];
	    } else {
	        return e1[0] - e2[0];
	    }
	});

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    x = Integer.parseInt(st.nextToken());
		    y = Integer.parseInt(st.nextToken());
		    
		    pq.add(new int[] {x, y});
		}
		
		long answer = 0;
		long start = 0;
		long end = 0;
		
		int[] now = pq.poll();
		start = now[0];
		end = now[1];
		
		while (!pq.isEmpty()) {
		    now = pq.poll();
		    
		    if (now[0] <= end && now[1] > end) {
		        end = now[1];
		    } else if (now[0] > end) {
		        answer += (end - start);
		        start = now[0];
		        end = now[1];
		    }
		}
		answer += (end - start);
		
		System.out.println(answer);
	}
}
