import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.offerFirst(x);
            } else if (order.equals("push_back")) {
                int y = Integer.parseInt(st.nextToken());
                deque.offer(y);
            } else if (order.equals("pop_front")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.poll());
                }
            } else if (order.equals("pop_back")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (order.equals("size")) {
                System.out.println(deque.size());
            } else if (order.equals("empty")) {
                if (deque.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peek());
                }
            } else if (order.equals("back")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }            
    }
}