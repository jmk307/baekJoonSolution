import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int M, N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                list.add(i);
                sum += i;
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(Collections.min(list));
        }
    }
}