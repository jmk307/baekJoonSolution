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

        String target = br.readLine().substring(0, 5);

        N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine().substring(0, 5);

            if (input.equals(target)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}