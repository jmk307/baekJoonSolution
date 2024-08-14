import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B, C;

    static Map<Integer, Integer> map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        String total = String.valueOf(A * B * C);
        String[] arrays = total.split("");

        map = new HashMap<>();
        for (String i : arrays) {
            int current = Integer.parseInt(i);

            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                int count = map.get(current);
                count++;
                map.put(current, count);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (map.get(i) == null) {
                System.out.println(0);
            } else {
                System.out.println(map.get(i));
            }
        }
    }
}