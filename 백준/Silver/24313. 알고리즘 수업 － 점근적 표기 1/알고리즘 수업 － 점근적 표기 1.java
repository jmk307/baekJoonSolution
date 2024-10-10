import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int a1, a0, c, n0;

    static int[] matrix;
    static boolean[] visited;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());

        boolean isAnswer = true;
        for (int i = n0; i <= 100; i++) {
            if (a1 * i + a0 > c * i) {
                isAnswer = false;
                break;
            }
        }

        if (isAnswer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}