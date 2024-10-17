import java.util.*;
import java.io.*;

public class Main {
    static int N, K, M;
    
    static long[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        
        List<Integer> list = new ArrayList<>();
        int count = 0;
        boolean isRight = true;
        while (!deque.isEmpty()) {
            if (count == M) {
                if (isRight) {
                    isRight = false;
                } else {
                    isRight = true;
                }
                
                count = 0;
            }
            
            if (isRight) {
                for (int i = 0; i < K - 1; i++) {
                    deque.add(deque.poll());
                }
                list.add(deque.poll());
            } else {
                for (int i = 0; i < K - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
                list.add(deque.pollLast());
            }
            
            count++;
        }
        
        for (int i : list) {
            System.out.println(i);
        }
    }
}
