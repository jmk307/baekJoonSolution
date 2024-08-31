import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static long[] distances;
    static long[] prices;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        prices = new long[N];
        distances = new long[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long sum = distances[0];
        long currentPrice = prices[0];

        for (int i = 1; i < N - 1; i++) {
            if (prices[i] < currentPrice) {
                answer += sum * currentPrice;
                currentPrice = prices[i];
                sum = 0;
            }

            sum += distances[i];
        }

        if (sum != 0) {
            answer += sum * currentPrice;
        }

        System.out.println(answer);
    }
}