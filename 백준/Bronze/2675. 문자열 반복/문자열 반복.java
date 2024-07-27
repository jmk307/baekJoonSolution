import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int T, R;
    static String S;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            String[] arrays = S.split("");

            sb = new StringBuilder();
            for (String array : arrays) {
                for (int k = 0; k < R; k++) {
                    sb.append(array);
                }
            }

            System.out.println(sb);
        }
    }
}