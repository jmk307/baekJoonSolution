import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, k;

    static List<Long> list = new ArrayList<>();
    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());

        double sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum += (list.get(i) / 2.0);
        }

        System.out.println(sum);
    }
}