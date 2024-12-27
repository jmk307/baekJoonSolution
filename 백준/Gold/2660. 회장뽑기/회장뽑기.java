import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        answer = new int[N + 1];

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("-1 -1")) {
                break;
            }

            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a].add(b);
            matrix[b].add(a);
        }


        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int currentMax = BFS(new Node(i, 0));

            min = Math.min(min, currentMax);
            answer[i] = currentMax;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (answer[i] == min) {
                list.add(i);
            }
        }

        System.out.println(min + " " + list.size());
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    static int BFS(Node v) {
        visited[v.node] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(v);
        int result = 0;

        while (!que.isEmpty()) {
            Node now = que.poll();

            result = Math.max(result, now.depth);

            for (int i : matrix[now.node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(new Node(i, now.depth + 1));
                }
            }
        }

        return result;
    }
}

class Node {
    int node;

    int depth;

    public Node(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}