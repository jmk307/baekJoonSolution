import java.util.*;
import java.io.*;

public class Main {
    static int Q;
    
    static Map<Long, Long> map = new HashMap<>();
    
    static int[] A;
    static int[] answer;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Q = Integer.parseInt(br.readLine());
        
        for (int j = 0; j < Q; j++) {
            st = new StringTokenizer(br.readLine());
            
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            if (a == 1) {
                long max = 0;
                for (long i = b; i <= b + 3; i++) {
                    if (map.containsKey(i)) {
                        max = Math.max(max, map.get(i));
                    }
                }
                max++;
                
                for (long i = b; i <= b + 3; i++) {
                    map.put(i, max);
                }
            } else if (a == 2) {
                if (map.containsKey(b)) {
                    map.put(b, map.get(b) + 4);
                } else {
                    map.put(b, map.getOrDefault(b, 4L));
                }
            } else {
                if (map.containsKey(b)) {
                    System.out.println(map.get(b));
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
