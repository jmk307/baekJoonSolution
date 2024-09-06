import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static Deque<Integer> que = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String word = st.nextToken();

            if (word.equals("push")) {
                que.add(Integer.parseInt(st.nextToken()));
            } else if (word.equals("pop")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(que.poll()).append("\n");
                }
            } else if (word.equals("size")) {
                sb.append(que.size()).append("\n");
            } else if (word.equals("empty")) {
                if (que.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (word.equals("front")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(que.peek()).append("\n");
                }
            } else if (word.equals("back")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(que.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}