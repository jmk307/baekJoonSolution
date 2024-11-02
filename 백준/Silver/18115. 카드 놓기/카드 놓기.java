import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static Stack<Integer> stack = new Stack<>();
    static Deque<Integer> deque = new ArrayDeque<>();
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 1; i <= N; i++) {
            int now = stack.pop();
            
            if (now == 1) {
                deque.addFirst(i);
            } else if (now == 2) {
                int prev = deque.poll();
                deque.addFirst(i);
                deque.addFirst(prev);
            } else {
                deque.add(i);
            }
        }
        
        for (int i : deque) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        
        System.out.println(sb);
    }
}