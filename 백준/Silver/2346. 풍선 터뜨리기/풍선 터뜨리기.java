import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix;
    
    static Deque<Integer> dq = new ArrayDeque<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
            dq.add(i);
        }
        
        int next = 1;
        sb.append(1).append(" ");
        dq.poll();
        while (!dq.isEmpty()) {
            int now = matrix[next];
            if (now > 0) {
                for (int i = 0; i < now - 1; i++) {
                    dq.add(dq.poll());
                }
                next = dq.poll();
                sb.append(next).append(" ");
            } else if (now < 0) {
                for (int i = 0; i < Math.abs(now) - 1; i++) {
                    dq.addFirst(dq.pollLast());
                }
                next = dq.pollLast();
                sb.append(next).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}