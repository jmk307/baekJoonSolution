import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, A, B;
    static long sum = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix, replace;
    static List<Long> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            while (A != 0) {
                a.add(A);

                A /= 2;
            }
            Collections.sort(a, Collections.reverseOrder());

            while (B != 0) {
                b.add(B);

                B /= 2;
            }
            Collections.sort(b, Collections.reverseOrder());

            int answer = 1;
            for (int j : a) {
                for (int k : b) {
                    if (j == k) {
                        answer = Math.max(answer, j);
                    }
                }
            }

            System.out.println(answer * 10);
        }
    }
}