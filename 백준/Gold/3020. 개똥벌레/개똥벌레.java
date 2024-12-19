import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, H;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] up, down;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[H + 2];
        up =  new int[H + 2];

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                down[now]++;
            } else {
                up[H - now + 1]++;
            }
        }

        for (int i = 1; i <= H; i++) {
            down[i] += down[i-1];
        }

        for (int i = H; i >= 1; i--) {
            up[i] += up[i+1];
        }

        int min = N;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int gap = down[H] - down[i-1] + up[1] - up[i+1];

            if (gap < min) {
                count = 1;
                min = gap;
            } else if (gap == min) {
                count++;
            }
        }

        System.out.print(min);
        System.out.print(" ");
        System.out.print(count);
    }
}