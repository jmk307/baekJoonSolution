import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static String[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");

            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        matrix = new String[map.size()][2];

        int current = 0;
        for (String i : map.keySet()) {
            matrix[current][0] = i;
            matrix[current][1] = String.valueOf(map.get(i));

            current++;
        }

        Arrays.sort(matrix, (e1, e2) -> {
            return e1[0].compareTo(e2[0]);
        });

        for (String[] strings : matrix) {
            sb.append(strings[0]).append(" ").append(strings[1]).append("\n");
        }

        System.out.println(sb);
    }
}