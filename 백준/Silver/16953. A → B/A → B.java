import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static Long A, B;
    
    static Long answer = -1L;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        BFS(A, 0L);
        System.out.println(answer);
    }

    static void BFS(Long v, Long depth) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(v, depth));

        while (!que.isEmpty()) {
            Node currentNode = que.poll();
            Long current = currentNode.now;
            // System.out.println(current);
            Long currentDepth = currentNode.depth;
            
            if (current.equals(B)) {
                answer = currentDepth + 1;
            }
            
            currentDepth++;
            
            Long a = 2 * current;
            if (a <= B) {
                que.add(new Node(a, currentDepth));
            }
            
            Long b = 10 * current + 1;
            if (b <= B) {
                que.add(new Node(b, currentDepth));
            }
        }
    }
}

class Node {
    Long now;
    
    Long depth;
    
    public Node(Long now, Long depth) {
        this.now = now;
        this.depth = depth;
    }
}