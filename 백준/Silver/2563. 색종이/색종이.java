import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static boolean[][] matrix = new boolean[100][100];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());

            for (int y = down; y < down + 10; y++) {
                for (int x = left; x < left + 10; x++) {
                    matrix[y][x] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[j][i]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}