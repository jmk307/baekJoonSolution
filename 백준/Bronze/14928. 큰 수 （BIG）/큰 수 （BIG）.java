import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String N;

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        long temp = 0;
        for (int i = 0; i < N.length(); i++) {
            temp = (temp * 10 + (N.charAt(i) - '0')) % 20000303;
        }

        System.out.println(temp);
    }
}