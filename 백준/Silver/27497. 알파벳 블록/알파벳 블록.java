import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int[] matrix;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static Deque<String> deque = new ArrayDeque<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            String b = "";
            if (a == 1 || a == 2) {
                b = st.nextToken();
            }

            if (a == 1) {
                deque.add(b);
                stack.push(1);
            } else if (a == 2) {
                deque.addFirst(b);
                stack.push(2);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == 1) {
                        deque.pollLast();
                        stack.pop();
                    } else if (stack.peek() == 2) {
                        deque.poll();
                        stack.pop();
                    }
                }
            }
        }

        for (String i : deque) {
            sb.append(i);
        }

        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}