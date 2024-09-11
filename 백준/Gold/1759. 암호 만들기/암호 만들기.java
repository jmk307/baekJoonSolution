import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int L, C;
    
    static char[] matrix;
    static char[] result;
    static boolean[] visited;
    
    static Map<Character, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        matrix = new char[C];
        result = new char[L];
        visited = new boolean[C];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            matrix[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(matrix);
        
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        
        int first = ((int) matrix[0]) - 1;
        backTracking(0, 0, 0, 0);
        
        System.out.println(sb);
    }
    
    static void backTracking(int depth, int start, int a, int b) {
        if (depth == L) {
            if (a >= 1 && b >= 2) {
                for (int i = 0; i < depth; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            
            return;
        }
        
        for (int i = start; i < C; i++) {
            result[depth] = matrix[i];
            if (map.containsKey(matrix[i])) {
                backTracking(depth + 1, i + 1, a + 1, b);
            } else {
                backTracking(depth + 1, i + 1, a, b + 1);
            }
        }
        
        /*for (int i = 0; i < C; i++) {
            if (!visited[i] && prev < (int) matrix[i]) {
                visited[i] = true;
                result[depth] = matrix[i];
                if (map.containsKey(matrix[i])) {
                    backTracking(depth + 1, matrix[i], a + 1, b);
                } else {
                    backTracking(depth + 1, matrix[i], a, b + 1);
                }
                
                visited[i] = false;
            }
        }*/
    }
}