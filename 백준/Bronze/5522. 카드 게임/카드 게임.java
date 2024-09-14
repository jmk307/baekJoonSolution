import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;

        String input = "";
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }

            sum += Integer.parseInt(input);
        }

        System.out.println(sum);
    }
}