import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, distanceSum;

    static int[] distances;
    static int[] prices;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        prices = new int[N];
        distances = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        distanceSum = 0;
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
            distanceSum += distances[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int minPrice = 0;
        int i = 0;
        while (true) {
            if (sum == distanceSum) {
                break;
            }

            int currentPrice = prices[i];
            int nextPrice = prices[i + 1];

            if (i == N - 2) {
                minPrice += currentPrice * distances[i];
                sum += distances[i];
                break;
            }

            if (currentPrice * (distances[i] + distances[i + 1]) > currentPrice * distances[i] + nextPrice * distances[i + 1]) {
                minPrice += currentPrice * distances[i];
                sum += distances[i];
                i++;
            } else {
                minPrice += currentPrice * (distances[i] + distances[i + 1]);
                sum += distances[i] + distances[i + 1];
                i += 2;
            }
        }

        System.out.println(minPrice);
    }
}