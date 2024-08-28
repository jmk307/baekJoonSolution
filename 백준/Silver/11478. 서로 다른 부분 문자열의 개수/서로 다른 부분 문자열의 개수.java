import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String S;

    static Set<String> set = new HashSet<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 0; j < S.length() - i + 1; j++) {
                set.add(S.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}