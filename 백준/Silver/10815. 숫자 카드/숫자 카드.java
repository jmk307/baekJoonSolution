import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;

    static Map<Integer, Integer> map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                int count = map.get(current);
                count++;
                map.put(current, count);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int current = Integer.parseInt(st.nextToken());

            if (map.containsKey(current)) {
                sb.append(map.get(current)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}