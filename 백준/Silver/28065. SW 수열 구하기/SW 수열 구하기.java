import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, B;

    static int[] input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        input = new int[N];

        int current = N - 1;

        input[0] = 1;
        boolean isPlus = true;
        for (int i = 1; i < N; i++) {
            if (isPlus) {
                input[i] = input[i-1] + current;

                isPlus = false;
            } else {
                input[i] = input[i-1] - current;

                isPlus = true;
            }

            current--;
        }

        for (int i : input) {
            System.out.println(i);
        }
    }
}