import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;

        int sum = 0;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }

            if (!map.containsKey(input)) {
                list.add(input);
            }

            map.put(input, map.getOrDefault(input, 0) + 1);

            sum++;
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            double current = (double) map.get(list.get(i)) / (double) sum * 100.0;
            String result = String.format("%.4f", current);

            System.out.println(list.get(i) + " " + result);
        }
    }
}