import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, M, N, x, y;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcm = lcm(M, N);

            boolean found = false;

            for (int year = x; year <= lcm; year += M) {
                if ((year - 1) % N + 1 == y) {
                    System.out.println(year);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}