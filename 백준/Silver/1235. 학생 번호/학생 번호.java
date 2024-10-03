import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static Set<Long> set = new HashSet<>();

    static String[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine();
        }

        int answer = 0;
        for (int i = matrix[0].length() - 1; i >= 0; i--) {
            set = new HashSet<>();

            for (int j = 0; j < N; j++) {
                set.add(Long.parseLong(matrix[j].substring(i)));
            }

            if (set.size() == N) {
                answer = i;
                break;
            }
        }

        System.out.println(matrix[0].length() - answer);
    }
}