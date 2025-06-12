import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static int[] matrix, isbn;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        matrix = new int[13];
        isbn = new int[] {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1};

        String input = br.readLine();
        for (int i = 0; i < 13; i++) {
            matrix[i] = input.charAt(i) - '0';
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            int current = 0;
            for (int j = 0; j < 13; j++) {
                if (matrix[j] != -6) {
                    current += isbn[j] * matrix[j];
                } else {
                    current += isbn[j] * i;
                }
            }
            current %= 10;

            if (current == 0) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}