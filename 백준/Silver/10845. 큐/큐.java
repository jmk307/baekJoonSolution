import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();
        int count = Integer.parseInt(br.readLine());
        int last = 0;
        
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                que.offer(last);
            } else if (order.equals("pop")) {
                if (que.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.poll());
                }
            } else if (order.equals("size")) {
                System.out.println(que.size());
            } else if (order.equals("empty")) {
                if (que.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if (que.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.peek());
                }
            } else if (order.equals("back")) {
                if (que.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(last);
                }   
            }            
        }
    }
}