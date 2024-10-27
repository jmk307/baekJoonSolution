import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static String S, E, Q;

    static int SH, SM, EH, EM, QH, QM;

    static int[] matrix;

    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();

        SH = Integer.parseInt(S.split(":")[0]);
        SM = Integer.parseInt(S.split(":")[1]);

        EH = Integer.parseInt(E.split(":")[0]);
        EM = Integer.parseInt(E.split(":")[1]);

        QH = Integer.parseInt(Q.split(":")[0]);
        QM = Integer.parseInt(Q.split(":")[1]);

        String input = "";
        Set<String> set = new HashSet<>();
        while ((input = br.readLine()) != null) {
            if (input.equals("")) {
                break;
            }

            st = new StringTokenizer(input);
            String current = st.nextToken();
            String name = st.nextToken();

            int currentH = Integer.parseInt(current.split(":")[0]);
            int currentM = Integer.parseInt(current.split(":")[1]);

            if (currentH < SH || (currentH == SH && currentM <= SM)) {
                map.put(name, 0);
            } else if (currentH > EH || (currentH == EH && currentM >= EM)) {
                if (currentH < QH || (currentH == QH && currentM <= QM)) {
                    if (map.containsKey(name) && map.get(name) == 0) {
                        set.add(name);
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}