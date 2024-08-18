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

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] arrays = input.split("");
            int[] result = new int[arrays.length];
            int sum = 0;

            String start = arrays[0];
            if (start.equals("O")) {
                result[0] = 1;
            }
            for (int j = 1; j < arrays.length; j++) {
                if (arrays[j-1].equals("O") && arrays[j].equals("O")) {
                    result[j] = result[j-1] + 1;
                }

                if (arrays[j-1].equals("X") && arrays[j].equals("O")) {
                    result[j] = 1;
                }

                if (arrays[j-1].equals("O") && arrays[j].equals("X")) {
                    result[j] = 0;
                }
            }

            for (int j = 0; j < result.length; j++) {
                sum += result[j];
            }

            System.out.println(sum);
        }
    }
}