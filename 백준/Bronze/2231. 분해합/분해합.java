import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            String current = String.valueOf(i);
            int sum = Integer.parseInt(current);

            String[] arrays = current.split("");

            for (String array : arrays) {
                sum += Integer.parseInt(array);
            }

            if (sum == N) {
                answer = Integer.parseInt(current);
                break;
            }
        }

        System.out.println(answer);
    }
}