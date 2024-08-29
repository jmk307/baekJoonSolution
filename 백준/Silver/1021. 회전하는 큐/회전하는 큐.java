import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;

    static Deque<Integer> deque = new ArrayDeque<>();
    static int[] targets;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            deque.add(i);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int idx = 0;

            for (Integer num : deque) {
                if (num == target) {
                    break;
                }
                idx++;
            }

            int leftCount = idx;
            int rightCount = deque.size() - idx;

            if (leftCount <= rightCount) {
                for (int j = 0; j < leftCount; j++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int j = 0; j < rightCount; j++) {
                    deque.addFirst(deque.pollLast());
                }
            }

            deque.pollFirst();
            answer += Math.min(leftCount, rightCount);
        }

        System.out.println(answer);
    }
}