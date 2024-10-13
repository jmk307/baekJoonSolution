import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static Deque<Integer> deque = new ArrayDeque<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        while (true) {
            if (deque.size() == 1) {
                break;
            }

            answer.add(deque.poll());
            deque.add(deque.poll());
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }
        sb.append(deque.peek());

        System.out.println(sb);
    }
}