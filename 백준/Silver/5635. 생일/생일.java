import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n;
    static String S;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static boolean[][] visited;
    static String[][] students;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        students = new String[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                students[i][j] = st.nextToken();
            }
        }

        Arrays.sort(students, (e1, e2) -> {
            if (Integer.parseInt(e1[3]) == Integer.parseInt(e2[3])) {
                if (Integer.parseInt(e1[2]) == Integer.parseInt(e2[2])) {
                    return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
                } else {
                    return Integer.parseInt(e1[2]) - Integer.parseInt(e2[2]);
                }
            } else {
                return Integer.parseInt(e1[3]) - Integer.parseInt(e2[3]);
            }
        });

        System.out.println(students[n-1][0]);
        System.out.println(students[0][0]);
    }
}