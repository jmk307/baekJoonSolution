import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static Long A, B;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(lcm(A, B));
    }

    static Long gcd(Long a, Long b) {
        if (b == 0L) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static Long lcm(Long a, Long b) {
        return a * b / gcd(a, b);
    }
}