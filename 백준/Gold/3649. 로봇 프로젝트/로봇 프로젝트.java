import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static long x, n;
    static int answer = -1;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[] matrix, calc, result;
    static List<Integer> list;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }

            x = Long.parseLong(input);
            x *= 10000000;

            n = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);

            boolean isAnswer = false;
            long a = 0;
            long b = 0;
            for (int i = 0; i < n - 1; i++) {
                long target = x - list.get(i);

                int start = i + 1;
                int end = (int) n - 1;

                while (start <= end) {
                    int midi = (start + end) / 2;
                    long midv = list.get(midi);

                    if (midv <= target) {
                        start = midi + 1;
                        if (midv == target) {
                            isAnswer = true;
                            a = list.get(i);
                            b = target;
                            break;
                        }
                    } else {
                        end = midi - 1;
                    }
                }

                if (isAnswer) {
                    break;
                }
            }

            if (isAnswer) {
                System.out.println("yes " + a + " " + b);
            } else {
                System.out.println("danger");
            }
        }
    }
}