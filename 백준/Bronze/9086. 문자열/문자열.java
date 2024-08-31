import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            String answer = "";

            answer += input.charAt(0);
            answer += input.charAt(input.length() - 1);

            System.out.println(answer);
        }
    }
}