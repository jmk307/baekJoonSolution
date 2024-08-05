import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int i = 1; i < 4; i++) {
            String input = br.readLine();

            if (!input.equals("Fizz") && !input.equals("Buzz") && !input.equals("FizzBuzz")) {
                answer = Integer.parseInt(input) + 4 - i;
            }
        }

        if (answer % 3 == 0 && answer % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (answer % 3 == 0) {
            System.out.println("Fizz");
        } else if (answer % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(answer);
        }
    }
}