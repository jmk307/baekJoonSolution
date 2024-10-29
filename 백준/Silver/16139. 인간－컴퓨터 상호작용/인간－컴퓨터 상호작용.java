import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static String S;
    static char a;

    static int q, l, r;

    static int[] matrix;
    static Map<Character, int[]> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();
        char[] chars = S.toCharArray();
        int[][] prefixCounts = new int[26][S.length()];

        prefixCounts[S.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < S.length(); i++) {
            int charIdx = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefixCounts[j][i] = prefixCounts[j][i - 1];
            }
            prefixCounts[charIdx][i]++;
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            a = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            int charIdx = a - 'a';
            if (l == 0) {
                sb.append(prefixCounts[charIdx][r]).append('\n');
            } else {
                sb.append(prefixCounts[charIdx][r] - prefixCounts[charIdx][l - 1]).append('\n');
            }
        }

        System.out.println(sb);
    }
}