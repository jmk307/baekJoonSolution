import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static String[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("")) {
                break;
            }

            N = Integer.parseInt(input);
            int n = (int) Math.pow(3, N);
            matrix = new String[n];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = "-";
            }

            recursiveCall(n, 0, n);

            for (String i : matrix) {
                if (i == "") {
                    sb.append(" ");
                } else {
                    sb.append(i);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void recursiveCall(int n, int a, int b) {
        if (n == 1) {
            return;
        }

        int count = n / 3;
        int start = a + count;
        int end = b - count;
        for (int i = start; i < end; i++) {
            matrix[i] = "";
        }

        recursiveCall(count, a, start);
        recursiveCall(count, end, b);
    }
}