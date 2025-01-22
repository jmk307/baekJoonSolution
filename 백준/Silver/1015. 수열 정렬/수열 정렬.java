import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] P, A, B;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N][2];
        P = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i][0] = i;
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        for (int i = 0; i < N; i++) {
            P[i][0] = i;
            P[i][1] = A[i][0];
        }

        Arrays.sort(P, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.print(P[i][0] + " ");
        }
    }
}