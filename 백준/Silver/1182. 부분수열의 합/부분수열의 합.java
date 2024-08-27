import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, S;
    static int count = 0;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void DFS(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }

            return;
        }

        DFS(index + 1, sum + matrix[index]);
        DFS(index + 1, sum);
    }
}