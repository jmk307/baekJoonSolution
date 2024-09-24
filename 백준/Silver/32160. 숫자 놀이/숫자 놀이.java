import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static Deque<Integer> deque = new ArrayDeque<>();
    
    static int answer = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        
        if (deque.size() == 2) {
            int a = deque.poll();
            int b = deque.poll();
            
            sb.append(b).append(" ").append(a).append("\n");
            
            System.out.println(b - a);
            System.out.println(sb);
        } else {
            while (true) {
                if (deque.size() == 3) {
                    break;
                }
                
                int a = deque.poll();
                int b = deque.poll();
                int c = deque.poll();
                sb.append(c).append(" ").append(a).append("\n");
                
                deque.addFirst(c-a);
                deque.addFirst(b);
            }
            
            int a = deque.poll();
            int b = deque.poll();
            sb.append(b).append(" ").append(a).append("\n");
            
            deque.addFirst(b-a);
            
            a = deque.poll();
            b = deque.poll();
            sb.append(b).append(" ").append(a).append("\n");
            
            System.out.println(b - a);
            System.out.println(sb);
        }
    }
}