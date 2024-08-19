import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int C, K, P;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i < C + 1; i++) {
            answer += (K * i + P * i * i);
        }

        System.out.println(answer);
    }
}