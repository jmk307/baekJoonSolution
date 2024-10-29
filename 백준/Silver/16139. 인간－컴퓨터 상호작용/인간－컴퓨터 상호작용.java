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

        for (char c : chars) {
            map.put(c, new int[S.length()]);
        }

        map.get(chars[0])[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            for (char c : map.keySet()) {
                map.get(c)[i] = map.get(c)[i - 1] + (chars[i] == c ? 1 : 0);
            }
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            a = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a)) {
                System.out.println(0);
            } else {
                int[] counts = map.get(a);
                if (l == 0) {
                    System.out.println(counts[r]);
                } else {
                    System.out.println(counts[r] - counts[l - 1]);
                }
            }
        }
    }
}