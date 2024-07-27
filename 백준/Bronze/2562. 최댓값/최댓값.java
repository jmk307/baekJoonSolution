import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        matrix = new int[9];
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < 9; i++) {
            matrix[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, matrix[i]);

            if (max == matrix[i]) {
                maxIndex = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex);
    }
}