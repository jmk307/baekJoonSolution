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

    static char[][] matrix, result;
    static int[][] hint;
    static String key, input;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        key = br.readLine();
        input = br.readLine();

        int N = key.length();
        int L = input.length() / N;

        matrix = new char[L][N];
        result = new char[L][N];

        char[] arrays = input.toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                matrix[j][i] = arrays[i * L + j];
            }
        }

        hint = new int[N][2];
        for (int i = 0; i < N; i++) {
            hint[i][0] = key.charAt(i) - 'A';
            hint[i][1] = i;
        }

        Arrays.sort(hint, (e1, e2) -> e1[0] - e2[0]);

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (key.charAt(i) == (char) (hint[j][0] + 'A') && !visited[j]) {
                    for (int a = 0; a < L; a++) {
                        result[a][i] = matrix[a][j];
                    }
                    visited[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
        }

        System.out.println(sb.toString());
    }
}