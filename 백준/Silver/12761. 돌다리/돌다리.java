import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int A, B, N, M;

    static int[][] matrix;
    static boolean[] visited = new boolean[100001];;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BFS(new Node(N, 0));
    }

    static void BFS(Node n) {
        Queue<Node> que = new LinkedList<>();
        visited[n.node] = true;
        que.add(new Node(n.node, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.node == M) {
                System.out.println(now.count);

                break;
            }

            int a = now.node + 1;
            int b = now.node - 1;
            int c = now.node + A;
            int d = now.node - A;
            int e = now.node + B;
            int f = now.node - B;
            int g = now.node * A;
            int h = now.node * B;

            if (a <= 100000 && !visited[a]) {
                visited[a] = true;
                que.add(new Node(a, now.count + 1));
            }

            if (b >= 0 && !visited[b]) {
                visited[b] = true;
                que.add(new Node(b, now.count + 1));
            }

            if (c <= 100000 && !visited[c]) {
                visited[c] = true;
                que.add(new Node(c, now.count + 1));
            }

            if (d >= 0 && !visited[d]) {
                visited[d] = true;
                que.add(new Node(d, now.count + 1));
            }

            if (e <= 100000 && !visited[e]) {
                visited[e] = true;
                que.add(new Node(e, now.count + 1));
            }

            if (f >= 0 && !visited[f]) {
                visited[f] = true;
                que.add(new Node(f, now.count + 1));
            }

            if (g <= 100000 && !visited[g]) {
                visited[g] = true;
                que.add(new Node(g, now.count + 1));
            }

            if (h <= 100000 && !visited[h]) {
                visited[h] = true;
                que.add(new Node(h, now.count + 1));
            }
        }
    }
}

class Node {
    int node;

    int count;

    public Node(int node, int count) {
        this.node = node;
        this.count = count;
    }
}