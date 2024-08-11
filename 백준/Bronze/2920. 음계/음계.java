import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int[] matrix = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        st = new StringTokenizer(input);

        for (int i = 0; i < 8; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        if (matrix[0] == 1) {
            boolean isAnswer = true;
            for (int i = 1; i < 9; i++) {
                if (matrix[i-1] != i) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                System.out.println("ascending");
            } else {
                System.out.println("mixed");
            }
        } else if (matrix[0] == 8) {
            boolean isAnswer = true;
            for (int i = 8; i > 0; i--) {
                if (matrix[8-i] != i) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                System.out.println("descending");
            } else {
                System.out.println("mixed");
            }
        } else {
            System.out.println("mixed");
        }
    }
}