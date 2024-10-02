import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, B;

    static String[] input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(1);
        } else {
            long answer = 1;

            for (int i = N; i >= 1; i--) {
                answer *= i;
            }

            System.out.println(answer);
        }
    }
}