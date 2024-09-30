import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static int root = -1;
    static int count = 0;
    static int delNode = -1;

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            if (current == -1) {
                root = i;
            } else {
                matrix[i].add(current);
                matrix[current].add(i);
            }
        }

        delNode = Integer.parseInt(br.readLine());
        for (int i : matrix[delNode]) {
            matrix[i].remove((Integer) delNode);
        }
        matrix[delNode].clear();

        DFS(root);

        System.out.println(count);
    }

    static void DFS(int v) {
        visited[v] = true;

        if (v != root && matrix[v].size() == 1) {
            count++;
        } else if (root != delNode && matrix[root].isEmpty()) {
            count++;
            return;
        }

        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}