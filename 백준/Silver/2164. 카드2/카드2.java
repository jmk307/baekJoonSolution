import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = N; i > 0; i--) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.pollLast();
            queue.addFirst(queue.pollLast());
        }

        System.out.println(queue.getFirst());
    }
}