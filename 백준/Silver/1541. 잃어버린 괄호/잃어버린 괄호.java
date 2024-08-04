import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int K, N, M;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "\\+|-", true);
        
        Queue<String> que = new LinkedList<>();
        while (st.hasMoreTokens()) {
            que.add(st.nextToken());
        }
        
        int sum = 0;
        while (que.size() != 0) {
            String current = que.poll();
            if (current.equals("-")) {
                int minusSum = 0;
                while (que.size() != 0) {
                    String now = que.poll();
                    if (!now.equals("+") && !now.equals("-")) {
                        minusSum += Integer.parseInt(now);
                    } else if (que.peek() == "-" || que.peek() == null) {
                        break;
                    }  
                }
                
                sum -= minusSum;
            } else if (!current.equals("+")) {
                sum += Integer.parseInt(current);
            }
        }
        
        System.out.println(sum);
    }
}