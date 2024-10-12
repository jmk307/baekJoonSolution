import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N;

    static List<BigInteger> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] current = br.readLine().toCharArray();

            String now = "";
            boolean isStart = false;
            for (char c : current) {
                if (Character.isDigit(c)) {
                    if (!isStart) {
                        isStart = true;
                        now += String.valueOf(c);
                    } else {
                        now += String.valueOf(c);
                    }
                } else {
                    if (isStart) {
                        list.add(new BigInteger(now));

                        now = "";
                        isStart = false;
                    }
                }
            }

            if (isStart) {
                list.add(new BigInteger(now));
            }
        }

        Collections.sort(list);

        for (BigInteger i : list) {
            System.out.println(i);
        }
    }
}