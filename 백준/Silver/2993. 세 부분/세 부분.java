import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, u, v;

    static char[] matrix;
    static boolean[] visited;
    static int index = 1;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            for (int j = 1; j < input.length(); j++) {
                int k = input.length() - (i + j);
                if (k > 0) {
                    String now = "";

                    sb = new StringBuilder();
                    sb.append(input.substring(0, i));
                    now += sb.reverse();

                    sb = new StringBuilder();
                    sb.append(input.substring(i, i + j));
                    now += sb.reverse();

                    sb = new StringBuilder();
                    sb.append(input.substring(i + j, i + j + k));
                    now += sb.reverse();

                    list.add(now);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}