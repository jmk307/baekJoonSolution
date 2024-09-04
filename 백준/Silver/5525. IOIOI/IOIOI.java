import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    static String S;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        String[] arrays = S.split("");
        int cnt = 0, ans = 0;
        for (int i = 1; i < M - 1;) {
            if (arrays[i].equals("O") && arrays[i + 1].equals("I")) {
                cnt++;
                if (cnt == N) {
                    if (arrays[i- (cnt*2 - 1)].equals("I"))
                        ans++;
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}