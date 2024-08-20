import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static boolean[] matrix = new boolean[31];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 28; i++) {
            int current = Integer.parseInt(br.readLine());
            matrix[current] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (!matrix[i]) {
                System.out.println(i);
            }
        }
    }
}