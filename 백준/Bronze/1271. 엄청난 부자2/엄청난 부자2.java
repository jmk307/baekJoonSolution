import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static BigInteger n, m;
    static String S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = new BigInteger(st.nextToken());
        m = new BigInteger(st.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}