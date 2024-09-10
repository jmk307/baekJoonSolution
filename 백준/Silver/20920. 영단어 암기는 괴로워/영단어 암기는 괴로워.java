import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static Map<String, Integer> map = new HashMap<>();
    
    static String[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String current = br.readLine();
            set.add(current);
            
            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                map.put(current, map.get(current) + 1);
            }
        }
        
        matrix = new String[set.size()];
        int i = 0;
        for (String current : set) {
            matrix[i] = current;
            i++;
        }
        
        Arrays.sort(matrix, (e1, e2) -> {
            if (map.get(e1) == map.get(e2) && e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            
            if (map.get(e1) == map.get(e2)) {
                return e2.length() - e1.length();
            } else {
                return map.get(e2) - map.get(e1);
            }
        });
        
        for (String current : matrix) {
            if (current.length() >= M) {
                sb.append(current).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}