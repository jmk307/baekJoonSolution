import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.') {
                break;
            }

            sb.append(solve(input)).append("\n");
        }

        System.out.println(sb);
            
    }

    static String solve(String input) {
        char[] arr = input.toCharArray();
    
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[') {
                stack.push(arr[i]);
            }

            if (arr[i] == ']') {
                if (stack.size() == 0 || stack.peek() != '[') {
                     return "no";
                }
                
                if (stack.peek() == '[') {
                    stack.pop();
                }
            }

            if (arr[i] == ')') {
                if (stack.size() == 0 || stack.peek() != '(') {
                    return "no";
                }
                
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}