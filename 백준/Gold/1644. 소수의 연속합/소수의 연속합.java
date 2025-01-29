import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M, S, E;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[] matrix;
    static boolean[] isPrime = new boolean[4000001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= 4000000; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(4000000); i++) {
            for (int j = i * i; j <= 4000000; j+=i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 4000000; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int count = 0;

        int sum = list.get(0);

        while (list.get(start) <= N) {
            if (sum < N) {
                end++;
                if (end == 283146) {
                    break;
                }
                sum += list.get(end);
            } else if (sum > N) {
                sum -= list.get(start);
                start++;
            } else if (sum == N) {
                count++;
                end++;
                if (end == 283146) {
                    break;
                }
                sum += list.get(end);
            }
        }

        System.out.println(count);
    }
}