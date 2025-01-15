import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, A, B;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};

    static int[] dp;
    static List<int[]> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int max = Math.max(A, B);
            int min = Math.min(A, B);

            list.add(new int[] {min, max});
        }
        Collections.sort(list, (e1, e2) -> {
            if (e1[0] * e1[1] == e2[0] * e2[1]) {
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                } else {
                    return e1[0] - e2[0];
                }
            } else {
                return e1[0] * e1[1] - e2[0] * e2[1];
            }
        });

        dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (list.get(j)[0] <= list.get(i)[0] && list.get(j)[1] <= list.get(i)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}