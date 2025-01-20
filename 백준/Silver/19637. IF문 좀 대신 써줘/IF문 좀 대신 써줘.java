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

    static int[] matrix, replace;
    static List<Long> list = new ArrayList<>();
    static Map<Long, String> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String title = st.nextToken();
            long power = Integer.parseInt(st.nextToken());

            map.putIfAbsent(power, title);
            list.add(power);
        }
        Collections.sort(list);

        for (int i = 0; i < M; i++) {
            long target = Integer.parseInt(br.readLine());

            int index = lowerBound(target);

            if (index == N) {
                sb.append(map.get(list.get(N-1))).append("\n");
            } else {
                sb.append(map.get(list.get(index))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int lowerBound(long v) {
        int start = -1;
        int end = N;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < v) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }
}