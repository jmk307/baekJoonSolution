import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new ArrayDeque<>();
        String problem = br.readLine();
        
        for (Character ch : problem.toCharArray()) {
            deque.offer(ch);
        }
        int count = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("L")) {
                if (deque.size() == 0) {
                    continue;
                } else {
                    stack.push(deque.pollLast());
                }
            } else if (order.equals("D")) {
                if (stack.size() == 0) {
                    continue;
                } else {
                    deque.offer(stack.pop());
                }
            } else if (order.equals("B")) {
                if (deque.size() == 0) {
                    continue;
                } else {
                    deque.pollLast();
                } 
            } else if (order.equals("P")) {
                deque.offer(st.nextToken().charAt(0));
            }
        }

        int stackSize = stack.size();
        
        if (stack.size() != 0) {
            for (int i = 0; i < stackSize; i++) {
                deque.offer(stack.pop());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Character ch : deque) {
            sb.append(ch);
        }
        
        System.out.println(sb);
    }
}