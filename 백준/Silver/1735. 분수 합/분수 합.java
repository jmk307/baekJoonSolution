import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A1, B1, A2, B2;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A1 = Integer.parseInt(st.nextToken());
        B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A2 = Integer.parseInt(st.nextToken());
        B2 = Integer.parseInt(st.nextToken());

        int B3 = lcm(B1, B2);
        int A3 = A1 * (B3 / B1) + A2 * (B3 / B2);

        int last = gcd(A3, B3);

        sb.append(A3 / last).append(" ").append(B3 / last);

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}