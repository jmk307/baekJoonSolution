import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String N;
    
    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = br.readLine();
        
        String[] arrays = N.split("");
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arrays.length; i++) {
            list.add(Integer.parseInt(arrays[i]));
        }
        Collections.sort(list);
        
        if (list.get(0) != 0) {
            System.out.println(-1);
        } else {
            matrix = list.stream().mapToInt(Integer::intValue).toArray();
            
            int sum = 0;
            for (int i : matrix) {
                sum += i;
            }
            
            if (sum % 3 != 0) {
                System.out.println(-1);
            } else {
                for (int i = matrix.length - 1; i >= 0; i--) {
                    sb.append(String.valueOf(matrix[i]));
                }
            
                System.out.println(sb);
            }
        }
        
    }
}