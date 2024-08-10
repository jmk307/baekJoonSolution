import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[j][i] = "*";
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                matrix[j][i] = "";
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[j][i] == "") {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[j][i]);
                }
            }
            System.out.println();
        }
    }
}