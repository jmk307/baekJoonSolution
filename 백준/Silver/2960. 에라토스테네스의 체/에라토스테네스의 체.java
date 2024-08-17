import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K;

    static boolean[] isPrime;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N + 1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count++;

                        if (count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}