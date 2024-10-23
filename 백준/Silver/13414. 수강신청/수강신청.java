import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int K, L;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < L; i++) {
            String current = br.readLine();

            if (map.containsKey(current)) {
                map.remove(current);
            }

            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        int count = 0;
        for (String i : map.keySet()) {
            System.out.println(i);
            count++;

            if (count == K) {
                break;
            }
        }
    }
}