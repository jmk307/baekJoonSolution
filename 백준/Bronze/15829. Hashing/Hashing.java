import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int L;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] chars = input.toCharArray();

        long sum = 0;
        long r = 1;
        long M = 1234567891L;

        for (int i = 0; i < chars.length; i++) {
            sum = (sum + (chars[i] - 'a' + 1) * r) % M;
            r = (r * 31) % M;
        }

        System.out.println(sum);
    }
}