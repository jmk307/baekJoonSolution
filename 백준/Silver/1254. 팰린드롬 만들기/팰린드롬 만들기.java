import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, L, H;
    static int max = 0;
    static int maxIndex = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static char[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] S = br.readLine().toCharArray();

        int count = S.length;
        int start = 0;
        int end = S.length - 1;

        while (true) {
            boolean isAnswer = true;

            int a = start;
            int b = end;
            while (a < b) {
                if (S[a] != S[b]) {
                    isAnswer = false;
                    break;
                }

                a++;
                b--;
            }

            if (isAnswer) {
                break;
            }

            count++;
            start++;
        }

        System.out.println(count);
    }
}