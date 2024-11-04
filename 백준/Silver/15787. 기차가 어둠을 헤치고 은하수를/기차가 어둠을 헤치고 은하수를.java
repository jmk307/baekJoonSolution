import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][21];

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());

            if (input == 1) {
                int x = Integer.parseInt(st.nextToken());
                matrix[now][x] = 1;
            } else if (input == 2) {
                int x = Integer.parseInt(st.nextToken());
                matrix[now][x] = 0;
            } else if (input == 3) {
                List<Integer> list = new ArrayList<>();

                for (int i = 1; i < 21; i++) {
                    if (matrix[now][i] == 1) {
                        matrix[now][i] = 0;
                        list.add(i);
                    }
                }

                for (int i : list) {
                    if (i != 20) {
                        matrix[now][i + 1] = 1;
                    }
                }
            } else {
                List<Integer> list = new ArrayList<>();

                for (int i = 1; i < 21; i++) {
                    if (matrix[now][i] == 1) {
                        matrix[now][i] = 0;
                        list.add(i);
                    }
                }

                for (int i : list) {
                    if (i != 1) {
                        matrix[now][i - 1] = 1;
                    }
                }
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {
            int[] current = matrix[i];

            String train = "";
            for (int j : current) {
                train += String.valueOf(j);
            }

            set.add(train);
        }

        System.out.println(set.size());
    }
}