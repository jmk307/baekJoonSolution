import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        B = Integer.parseInt(br.readLine());

        System.out.println(B / 11 * 10);
    }
}