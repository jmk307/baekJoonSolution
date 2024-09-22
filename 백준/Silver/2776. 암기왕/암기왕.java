import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N, M;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            Map<Integer, Integer> case1 = new HashMap<>();

            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                case1.put(Integer.parseInt(st.nextToken()), 0);
            }

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int current = Integer.parseInt(st.nextToken());

                if (case1.containsKey(current)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}