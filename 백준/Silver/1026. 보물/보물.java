import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static Integer[] A, B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (A[i] * B[i]);
        }

        System.out.println(sum);
    }
}