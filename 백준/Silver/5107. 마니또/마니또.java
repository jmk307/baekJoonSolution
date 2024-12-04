import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	static Map<String, List<String>> map;
	static Map<String, Integer> visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input;
		int tmp = 1;
		while ((input = br.readLine()) != null) {
		    if (input.isEmpty()) {
		        break;
		    }
		    
		    N = Integer.parseInt(input);
		    if (N == 0) {
		        break;
		    }
		    
		    map = new HashMap<>();
		    visited = new HashMap<>();
		    for (int i = 0; i < N; i++) {
		        st = new StringTokenizer(br.readLine());
		        
		        String A = st.nextToken();
		        String B = st.nextToken();
		        
		        if (!map.containsKey(A)) {
		            List<String> list = new ArrayList<>();
		            list.add(B);
		            
		            map.put(A, list);
		        } else {
		            List<String> list = map.get(A);
		            list.add(B);
		            
		            map.put(A, list);
		        }
		        
		        if (!map.containsKey(B)) {
		            List<String> list = new ArrayList<>();
		            list.add(A);
		            
		            map.put(B, list);
		        } else {
		            List<String> list = map.get(B);
		            list.add(A);
		            
		            map.put(B, list);
		        }
		    }
		    
		    int count = 0;
	        for (String i : map.keySet()) {
	            if (!visited.containsKey(i)) {
	                DFS(i);
	                count++;
	            }
	        }
	        
	        sb.append(tmp).append(" ").append(count).append("\n");
		    tmp++;
		}
		
		System.out.println(sb);
	}
	
	static void DFS(String v) {
	    if (!visited.containsKey(v)) {
	        visited.put(v, 0);
	    }
	    
	    for (String i : map.get(v)) {
	        if (!visited.containsKey(i)) {
	            DFS(i);
	        }
	    }
	}
}
