import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;
    static char now, l, r;
    static String total = "";

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[26][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            now = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0);
            r = st.nextToken().charAt(0);

            if (l != '.') {
                matrix[now - 'A'][0] = l - 'A';
            } else {
                matrix[now - 'A'][0] = -1;
            }

            if (r != '.') {
                matrix[now - 'A'][1] = r - 'A';
            } else {
                matrix[now - 'A'][1] = -1;
            }
        }

        DFS(0);
        System.out.println(total);

        total = "";
        DFS2(0);
        System.out.println(total);

        total = "";
        DFS3(0);
        System.out.println(total);
    }

    static void DFS(int v) {
        if (v == -1) {
            return;
        }
        total += String.valueOf((char) (v + 'A'));

        DFS(matrix[v][0]);
        DFS(matrix[v][1]);
    }

    static void DFS2(int v) {
        if (v == -1) {
            return;
        }

        DFS2(matrix[v][0]);
        total += String.valueOf((char) (v + 'A'));
        DFS2(matrix[v][1]);
    }

    static void DFS3(int v) {
        if (v == -1) {
            return;
        }

        DFS3(matrix[v][0]);
        DFS3(matrix[v][1]);

        total += String.valueOf((char) (v + 'A'));
    }
}