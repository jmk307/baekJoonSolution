import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String order = br.readLine();
        Double result = 0.00;
        Stack<Double> stack = new Stack<>();
        HashMap<Character, Double> map = new HashMap<Character, Double>();

        char ch='A';
        for (int i = 0; i < count; i++) {
            map.put(ch, Double.parseDouble(br.readLine()));
            ch += 1;
        }

        for (Character c : order.toCharArray()) {
            if (c == '+') {
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if (c == '-') {
                Double back = stack.pop();
                Double front = stack.pop();
                result = front - back;
                stack.push(result);
            } else if (c == '*') {
                result = stack.pop() * stack.pop();
                stack.push(result);
            } else if (c == '/') {
                Double back = stack.pop();
                Double front = stack.pop();
                result = front / back;
                stack.push(result);
            } else {
                stack.push(map.get(c));
            }
        }

        System.out.printf("%.2f", result);
    }
}