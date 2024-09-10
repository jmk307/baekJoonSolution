import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static Map<Long, Long> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        long max = 0;
        long x = 0;
        for (int i = 0; i < N; i++) {
            long current = Long.parseLong(br.readLine());
            
            map.put(current, map.getOrDefault(current, 0L) + 1L);
            
            if (map.get(current) > max) {
                max = map.get(current);
                x = current;
            } else if (map.get(current) == max) {
                x = Math.min(x, current);
            }
        }
        
        System.out.println(x);
    }
}