import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static long N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[] visited;
    static Map<String, Boolean> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map.put("ChongChong", true);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            boolean a = false;
            boolean b = false;

            if (!map.containsKey(A)) {
                map.put(A, false);
            } else {
                a = map.get(A);
            }

            if (!map.containsKey(B)) {
                map.put(B, false);
            } else {
                b = map.get(B);
            }

            if (a || b) {
                map.put(A, true);
                map.put(B, true);
            }
        }

        int count = 0;
        for (String i : map.keySet()) {
            if (map.get(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}