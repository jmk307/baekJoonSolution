import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        double answer = W * H / 2;

        System.out.printf("%.1f", answer);
    }
}