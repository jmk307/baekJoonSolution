import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, N, M;
    static String S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(2*M - N).append(" ").append(M - (2*M - N)).append("\n");
        }

        System.out.println(sb);
    }
}