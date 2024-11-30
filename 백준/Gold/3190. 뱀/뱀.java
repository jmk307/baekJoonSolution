import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, K, L;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] matrix;
    static int[][] direction;

    static StringBuilder sb = new StringBuilder();
    static final long div = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 2;
        }

        L = Integer.parseInt(br.readLine());
        direction = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            String turn = st.nextToken();

            if (turn.equals("D")){
                direction[i][0] = count;
                direction[i][1] = 1;
            } else {
                direction[i][0] = count;
                direction[i][1] = -1;
            }
        }

        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[] {1, 1});
        matrix[1][1] = 3;

        int[] current = new int[] {1, 1};
        int second = 0;
        int idx = 0;
        int d = 0;
        while (true) {
            second++;

            int[] next = new int[] {current[0] + dx[d], current[1] + dy[d]};

            if (next[0] == 0 || next[1] == 0
                    || next[0] == N + 1 || next[1] == N + 1
                    || matrix[next[0]][next[1]] == 3) {
                break;
            }

            current = next;
            if (matrix[next[0]][next[1]] == 0) {
                int[] tmp = snake.poll();
                matrix[tmp[0]][tmp[1]] = 0;
            }
            snake.add(new int[]{current[0], current[1]});
            matrix[current[0]][current[1]] = 3;

            if (idx < L && direction[idx][0] == second) {
                d = (4 + d + direction[idx][1]) % 4;
                idx++;
            }
        }

        System.out.println(second);
    }
}