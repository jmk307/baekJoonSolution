import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, L, H;
    static int max = 0;
    static int maxIndex = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix;
    static char[] input;
    static int[] result;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine().toCharArray();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            map.putIfAbsent(br.readLine(), 0);
        }

        matrix = new int[26];

        for (int i = 0; i < 26; i++) {
            matrix[i] = 'a' - '0' + i;
        }

        while (true) {
            sb = new StringBuilder();

            for (char i : input) {
                sb.append((char) (matrix[i - 'a'] + '0'));
            }

            boolean isAnswer = false;
            for (String i : map.keySet()) {
                if (sb.toString().contains(i)) {
                    isAnswer = true;
                    break;
                }
            }

            if (isAnswer) {
                System.out.println(sb.toString());
                break;
            }

            int temp = matrix[25];
            for (int i = 24; i >= 0; i--) {
                matrix[i+1] = matrix[i];
            }
            matrix[0] = temp;
        }
    }
}