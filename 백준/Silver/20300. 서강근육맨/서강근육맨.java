import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static long[] matrix;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(matrix);
        
        Deque<Long> deque = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            deque.add(matrix[i]);
        }
        
        long max = -1;
        int size = deque.size();
        if (size % 2 == 0) {
            for (int i = 1; i <= size / 2; i++) {
                long current = 0L;
                
                current += deque.poll();
                current += deque.pollLast();
                
                max = Math.max(max, current);
            }
        } else {
            max = Math.max(max, deque.pollLast());
            
            int now = size - 1;
            
            for (int i = 1; i <= now / 2; i++) {
                long current = 0L;
                
                current += deque.poll();
                current += deque.pollLast();
                
                max = Math.max(max, current);
            }
        }
        
        System.out.println(max);
    }
}