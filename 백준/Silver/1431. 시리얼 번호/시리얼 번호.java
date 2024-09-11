import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static String[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new String[N][3];
        
        for (int i = 0; i < N; i++) {
            String current = br.readLine();
            
            int length = current.length();
            
            int sum = 0;
            for (char c : current.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += Integer.parseInt(String.valueOf(c));;
                }
            }
            
            matrix[i][0] = current;
            matrix[i][1] = String.valueOf(length);
            matrix[i][2] = String.valueOf(sum);
        }
        
        Arrays.sort(matrix, (e1, e2) -> {
            if (e1[1].equals(e2[1])) {
                if (calculate(e1[0]) == calculate(e2[0])) {
                    return e1[0].compareTo(e2[0]);
                } else {
                    return calculate(e1[0]) - calculate(e2[0]);
                }
            } else {
                return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            sb.append(matrix[i][0]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int calculate(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				result += Integer.parseInt(s.substring(i, i + 1));
			}
        }
        
        return result;
    }
}