import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int count = 0;
        int current = 0;

        while (count != N) {
            current++;

            if (String.valueOf(current).contains("666")) {
                count++;
            }
        }

        System.out.println(current);
    }
}