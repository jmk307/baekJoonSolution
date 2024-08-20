import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static long N, M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        System.out.println(Math.abs(M - N));
    }
}