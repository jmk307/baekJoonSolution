import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] matrix;
    static Stack<Integer> stack = new Stack<>();
    static Map<Integer, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int now = Integer.parseInt(st.nextToken());
            map.put(now, i);

            if (stack.isEmpty()) {
                stack.push(now);
                matrix[i] = 0;
            } else {
                int answer = 0;
                while (!stack.isEmpty()) {
                    int peek = stack.peek();

                    if (peek < now) {
                        stack.pop();
                    } else {
                        answer = map.get(peek);
                        break;
                    }
                }

                matrix[i] = answer;
                stack.push(now);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(matrix[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}