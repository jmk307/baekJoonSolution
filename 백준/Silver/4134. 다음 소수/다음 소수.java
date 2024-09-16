import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int n;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long current = Long.parseLong(br.readLine());

            if (current == 0 || current == 1) {
                System.out.println(2);
            } else {
                while (true) {
                    if (isPrime(current)) {
                        System.out.println(current);
                        break;
                    } else {
                        current++;
                    }
                }
            }
        }
    }

    static boolean isPrime(long x) {
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}