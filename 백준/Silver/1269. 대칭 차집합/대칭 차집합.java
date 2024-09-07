import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B;

    static int[] a, b;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        a = new int[A];
        b = new int[B];

        Map<Integer, Integer> mapA = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            mapA.put(a[i], 0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < B; i++) {
            if (mapA.containsKey(b[i])) {
                count++;
            }
        }

        System.out.println(a.length - count + b.length - count);
    }
}