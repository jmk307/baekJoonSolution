import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if (N <= 99) {
            System.out.println(N);
        } else {
            int count = 0;

            for (int i = 100; i <= N; i++) {
                String[] arrays = String.valueOf(i).split("");
                boolean isSame = true;

                int prev = Integer.parseInt(arrays[0]) - Integer.parseInt(arrays[1]);
                for (int j = 1; j < arrays.length - 1; j++) {
                    int current = Integer.parseInt(arrays[j]) - Integer.parseInt(arrays[j + 1]);

                    if (current != prev) {
                        isSame = false;
                        break;
                    }

                    prev = current;
                }

                if (isSame) {
                    count++;
                }
            }

            System.out.println(99 + count);
        }


    }
}