import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    static String S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        String P1 = "IOI";

        for (int i = 0; i < N - 1; i++) {
            P1 += "OI";
        }

        String[] arrays = S.split("");
        int count = 0;
        for (int i = 0; i <= S.length() - P1.length(); i++) {
            String current = S.substring(i, i + P1.length());
            if (arrays[i].equals("I") && current.equals(P1)) {
                count++;
            }
        }

        System.out.println(count);
    }
}