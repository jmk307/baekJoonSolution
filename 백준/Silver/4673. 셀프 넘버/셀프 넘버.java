import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static boolean[] matrix = new boolean[100001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        findSelfNumber();

        for (int i = 1; i < 10001; i++) {
            if (!matrix[i]) {
                System.out.println(i);
            }
        }
    }

    static void findSelfNumber() {
        int start = 1;

        while (start != 10001) {
            int current = start;

            String a = String.valueOf(start);
            String[] arrays = a.split("");

            for (String array :arrays) {
                current += Integer.parseInt(array);
            }

            matrix[current] = true;

            start++;
        }
    }
}