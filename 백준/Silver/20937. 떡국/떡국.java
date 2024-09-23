import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        int max = 0;
        for (int i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }

        System.out.println(max);
    }
}