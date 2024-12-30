import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int start = -1;
    static int answer = 0;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};

    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static TreeSet<Integer> treeSet = new TreeSet<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            matrix[i].add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            count = 0;
            start = i;
            DFS(i, new ArrayList<>());
        }

        System.out.println(treeSet.size());
        for (int i : treeSet) {
            System.out.println(i);
        }
    }

    static void DFS(int v, ArrayList<Integer> l) {
        visited[v] = true;
        l.add(v);
        count++;

        for (int i : matrix[v]) {
            if (!visited[i]) {
                DFS(i, l);
            } else if (visited[i] && i == start) {
                for (int j : l) {
                    treeSet.add(j);
                }
            }
        }
    }
}