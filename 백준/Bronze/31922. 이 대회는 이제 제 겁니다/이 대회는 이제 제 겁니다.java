import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, P, C;
    static String S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(A + C, P));
    }
}