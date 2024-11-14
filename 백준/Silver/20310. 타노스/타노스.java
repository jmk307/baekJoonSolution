import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static String S;

    static int[][] matrix;
    static boolean[][] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();
        String[] arrays = S.split("");

        int countZero = 0;
        int countOne = 0;
        for (String i : arrays) {
            if (i.equals("0")) {
                countZero++;
            } else {
                countOne++;
            }
        }

        int a = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals("1")) {
                if (a < countOne / 2) {
                    arrays[i] = "";
                    a++;
                }
            }

            if (a == countOne / 2) {
                break;
            }
        }

        int b = 0;
        for (int i = arrays.length - 1; i >= 0; i--) {
            if (arrays[i].equals("0")) {
                if (b < countZero / 2) {
                    arrays[i] = "";
                    b++;
                }
            }

            if (b == countZero / 2) {
                break;
            }
        }

        String result = "";
        for (String i : arrays) {
            if (!i.isEmpty()) {
                result += i;
            }
        }

        System.out.println(result);
    }
}