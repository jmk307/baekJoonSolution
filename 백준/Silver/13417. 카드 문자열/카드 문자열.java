import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            Deque<String> deque = new ArrayDeque<>();
            deque.add(st.nextToken());
            
            for (int i = 0; i < N - 1; i++) {
                char current = st.nextToken().charAt(0);
                
                if (current - 'A' <= deque.peek().charAt(0) - 'A') {
                    deque.addFirst(String.valueOf(current));
                } else {
                    deque.add(String.valueOf(current));
                }
            }
            
            String result = "";
            for (String i : deque) {
                result += i;
            }
            
            System.out.println(result);
        }
    }
}