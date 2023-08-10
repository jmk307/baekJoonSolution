import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Queue에 1~N까지 값을 offer한다.
        for (int i = 1; i <= count; i++) {
            queue.offer(i);
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // Queue의 사이즈가 1일 때까지 반복한다.
        while(queue.size() > 1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로 보낸다.
            for (int i = 0; i < order - 1; i++) {
                queue.offer(queue.poll());
            }
            // K번째 값은 poll한 후 출력한다.
            sb.append(queue.poll() + ", ");
        }
        
        // Queue의 사이즈가 1일 때는 단순히 poll하면 된다.
        sb.append(queue.poll() + ">");
 
        System.out.println(sb);
    }
}