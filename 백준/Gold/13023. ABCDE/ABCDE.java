import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, a, b;
    static boolean isAnswer = false;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            backTracking(i, 0);
        }

        if (isAnswer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void backTracking(int v, int depth) {
        visited[v] = true;

        if (depth == 4) {
            isAnswer = true;
            
            return;
        }

        for (int i : matrix[v]) {
            if (!visited[i]) {
                backTracking(i, depth + 1);
            }
        }
        
        visited[v] = false;
    }
}