import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        long answer = (long) (A + B) * (A - B);

        System.out.println(answer);
    }
}