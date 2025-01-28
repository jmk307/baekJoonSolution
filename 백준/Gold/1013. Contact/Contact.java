import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};*/

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] dx2 = {-1, -1, 1, 1};
    static int[] dy2 = {-1, 1, -1, 1};

    static int[][] matrix;
    static boolean[][] visited;
    static List<int[]> clowns = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        String pattern = "(100+1+|01)+";

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            if (input.matches(pattern)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}