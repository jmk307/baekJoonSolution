import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static String[] input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = br.readLine().split("");

        long answer = 0;
        long count = 0;
        boolean isStart = false;
        for (int i = 0; i < N; i++) {
            if (!isStart) {
                if (input[i].equals("2")) {
                    isStart = true;
                    count++;
                }
            } else {
                if (input[i].equals("2")) {
                    count++;
                } else {
                    answer += sum(count);

                    isStart = false;
                    count = 0;
                }
            }
        }

        if (isStart) {
            answer += sum(count);
        }

        System.out.println(answer);
    }

    static long sum(long count) {
        long result = 0;

        for (int i = 1; i <= count; i++) {
            result += i * (count - i + 1);
        }

        return result;
    }
}