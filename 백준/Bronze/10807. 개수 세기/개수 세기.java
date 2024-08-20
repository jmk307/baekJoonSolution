import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

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

        int target = Integer.parseInt(br.readLine());
        if (map.containsKey(target)) {
            System.out.println(map.get(target));
        } else {
            System.out.println(0);
        }
    }
}