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

        int sum = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += (int) Math.pow(31, count) * (chars[i] - '0' - 48);
            count++;
        }

        System.out.println(sum);
    }
}