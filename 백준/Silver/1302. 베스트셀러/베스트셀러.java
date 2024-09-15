import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static Map<String, Integer> map = new HashMap<>();
    static String[][] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String current = br.readLine();
            
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        
        matrix = new String[map.keySet().size()][2];
        int idx = 0;
        for (String i : map.keySet()) {
            matrix[idx][0] = i;
            matrix[idx][1] = String.valueOf(map.get(i));
            
            idx++;
        }
        
        Arrays.sort(matrix, (e1, e2) -> {
            if (e1[1].equals(e2[1])) {
                return e1[0].compareTo(e2[0]);
            } else {
                return e2[1].compareTo(e1[1]);
            }
        });
        
        System.out.println(matrix[0][0]);
    }
}