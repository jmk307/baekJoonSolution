import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int n;
    static int[] matrix;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        matrix = new int[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(br.readLine());   
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int current = 0;
        while (i != n) {
            i++;
            
            if (i == matrix[current]) {
                stack.push(i);
                sb.append("+").append("\n");
                stack.pop();
                sb.append("-").append("\n");
                current++;
            } else {
                stack.push(i);
                sb.append("+").append("\n");
            }

            while (true) {
                if (stack.isEmpty()) {
                    break;
                }
                
                if (stack.peek() != matrix[current]) {
                    break;
                } else {
                    stack.pop();
                    sb.append("-").append("\n");
                    current++;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}