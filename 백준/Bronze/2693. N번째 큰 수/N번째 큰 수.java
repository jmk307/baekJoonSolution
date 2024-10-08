import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int T;

    static int[] matrix;
    static boolean[] visited;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        List<Integer> list;
        for (int i = 0; i < T; i++) {
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list, Collections.reverseOrder());

            System.out.println(list.get(2));
        }
    }
}