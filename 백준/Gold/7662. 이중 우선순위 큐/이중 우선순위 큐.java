import java.util.*;
import java.io.*;

public class Main {
	static int T, k, n;
	static String input;
	
	static TreeMap<Integer, Integer> map;

	static int[][] matrix;
	static boolean[][] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
		    k = Integer.parseInt(br.readLine());
		    
		    map = new TreeMap<>();
		    for (int j = 0; j < k; j++) {
		        st = new StringTokenizer(br.readLine());
		        
		        input = st.nextToken();
		        n = Integer.parseInt(st.nextToken());
		        
		        if (input.equals("I")) {
		            map.put(n, map.getOrDefault(n, 0) + 1);
		        } else if (input.equals("D")) {
		            if (n == -1) {
		                if (map.size() != 0) {
		                    if (map.get(map.firstKey()) == 1) {
		                        map.pollFirstEntry();
		                    } else {
		                        map.put(map.firstKey(), map.get(map.firstKey()) - 1);
		                    }
		                }
		            } else {
		                if (map.size() != 0) {
		                    if (map.get(map.lastKey()) == 1) {
		                        map.pollLastEntry();
		                    } else {
		                        map.put(map.lastKey(), map.get(map.lastKey()) - 1);
		                    }
		                }
		            }
		        }
		    }
		    
		    if (map.size() == 0) {
		        sb.append("EMPTY").append("\n");
		    } else {
		        sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
		    }
		}
		
		System.out.println(sb);
	}
}
