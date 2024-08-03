import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int k, n;
    
    static Map<String, List<String>> map;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                
                String name = st.nextToken();
                String kind = st.nextToken();
                
                if (!map.containsKey(kind)) {
                    List<String> names = new ArrayList<>();
                    names.add(name);
                    
                    map.put(kind, names);
                } else {
                    map.get(kind).add(name);
                }
                
            }
            
            int sum = 1;
            for (String key : map.keySet()) {
                int size = map.get(key).size();
                sum *= size + 1;
            }
            
            System.out.println(sum - 1);
        }
        
    }
}