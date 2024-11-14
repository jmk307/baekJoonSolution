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

        String result = "";
        for (int i = countZero / 2; i > 0; i--) {
            result += "0";
        }

        for (int i = countOne / 2; i > 0; i--) {
            result += "1";
        }

        System.out.println(result);
    }
}