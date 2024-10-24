import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static Map<String, List<String>> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int k = 0; k < N; k++) {
            String group = br.readLine();

            int count = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(br.readLine());
            }
            Collections.sort(list);

            map.put(group, list);
        }

        for (int i = 0; i < M; i++) {
            String current = br.readLine();
            String input = br.readLine();

            if (input.equals("0")) {
                for (String group : map.keySet()) {
                    if (group.equals(current)) {
                        for (String j : map.get(group)) {
                            System.out.println(j);
                        }
                    }
                }
            } else {
                for (String group : map.keySet()) {
                    if (map.get(group).contains(current)) {
                        System.out.println(group);
                    }
                }
            }
        }
    }
}