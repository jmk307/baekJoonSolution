import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static String N;

    static int[] matrix;
    static int[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        BigInteger bigInteger = new BigInteger(N);

        System.out.println(bigInteger.sqrt());
    }
}