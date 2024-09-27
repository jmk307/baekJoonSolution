import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (char c : chars) {
                sb.append(Character.toLowerCase(c));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}