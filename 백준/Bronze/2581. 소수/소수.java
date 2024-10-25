import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int M, N;

    static boolean[] isPrime = new boolean[10001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 10000; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 10000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}