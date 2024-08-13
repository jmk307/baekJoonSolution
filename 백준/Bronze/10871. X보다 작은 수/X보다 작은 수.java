import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, X;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            if (current < X) {
                sb.append(current).append(" ");
            }
        }

        System.out.println(sb);
    }
}