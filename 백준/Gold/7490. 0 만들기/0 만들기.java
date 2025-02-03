import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static String[] matrix;
    static boolean[] visited;
    static Map<String, Boolean> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            matrix = new String[2*N + 1];

            backTracking(1);

            Collections.sort(list);
            for (String j : list) {
                sb.append(j).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if (depth == N + 1) {
            String result = "";
            for (int i = 1; i <= 2 * N - 1; i++) {
                result += matrix[i];
            }

            Deque<String> deque = new ArrayDeque<>();
            int idx = 1;
            while (true) {
                if (idx == 2 * N) {
                    break;
                }

                if (matrix[idx].equals(" ")) {
                    String current = deque.pollLast();
                    idx++;
                    deque.add(current + matrix[idx]);
                } else {
                    deque.add(matrix[idx]);
                }

                idx++;
            }

            int sum = Integer.parseInt(deque.poll());
            while (!deque.isEmpty()) {
                String now = deque.poll();
                if (now.equals("+")) {
                    sum += Integer.parseInt(deque.poll());
                } else if (now.equals("-")) {
                    sum -= Integer.parseInt(deque.poll());
                }
            }

            if (sum == 0) {
                if (!list.contains(result)) {
                    list.add(result);
                }
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                matrix[2*(depth-1) + 1] = String.valueOf(depth);
                matrix[2*(depth-1) + 2] = "+";
                backTracking(depth + 1);
            }

            if (i == 1) {
                matrix[2*(depth-1) + 1] = String.valueOf(depth);
                matrix[2*(depth-1) + 2] = "-";
                backTracking(depth + 1);
            }

            if (i == 2) {
                matrix[2*(depth-1) + 1] = String.valueOf(depth);
                matrix[2*depth] = " ";
                backTracking(depth + 1);
            }
        }
    }
}