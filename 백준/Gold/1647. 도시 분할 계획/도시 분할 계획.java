import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, A, B, C;
    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }

        int count = 0;
        int result = 0;
        while (count < N - 2) {
            Edge now = pq.poll();

            if (find(now.a) != find(now.b)) {
                count++;
                union(now.a, now.b);
                result += now.c;
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}

class Edge implements Comparable<Edge> {
    int a;

    int b;

    int c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Edge o) {
        return this.c - o.c;
    }
}