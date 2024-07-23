import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int x, y;

    static int[][] matrix;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int start = 1;

                if (matrix[i][0] < matrix[j][0] && matrix[i][1] < matrix[j][1]) {
                    answer[i]++;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}