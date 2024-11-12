import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, K;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int current = Integer.parseInt(br.readLine());

            if (current < 40) {
                sum += 40;
            } else {
                sum += current;
            }
        }

        System.out.println(sum / 5);
    }
}