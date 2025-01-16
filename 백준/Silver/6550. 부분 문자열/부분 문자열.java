import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, d, s;
    static int max = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] matrix, replace;
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }

            st = new StringTokenizer(input);

            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int index = 0;
            boolean isAnswer = false;

            for (char i : t) {
                if (s[index] == i) {
                    index++;

                    if (index == s.length) {
                        isAnswer = true;
                        break;
                    }
                }
            }

            if (isAnswer) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}