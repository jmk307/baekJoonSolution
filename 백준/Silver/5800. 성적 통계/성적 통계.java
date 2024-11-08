import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int K, N;

    static String[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int i = 1; i < K + 1; i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list, Collections.reverseOrder());

            int gap = 0;
            for (int j = 0; j < N - 1; j++) {
                gap = Math.max(gap, list.get(j) - list.get(j + 1));
            }

            sb.append("Class ").append(i).append("\n");
            sb.append("Max ")
                    .append(Collections.max(list)).append(", ")
                    .append("Min ")
                    .append(Collections.min(list)).append(", ")
                    .append("Largest gap ")
                    .append(gap).append("\n");
        }

        System.out.println(sb);
    }
}