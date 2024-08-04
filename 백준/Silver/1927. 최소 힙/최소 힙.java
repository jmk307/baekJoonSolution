import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            Long current = Long.parseLong(br.readLine());
            
            if (current == 0) {
                if (pq.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(current);
            }
        }
    }
}