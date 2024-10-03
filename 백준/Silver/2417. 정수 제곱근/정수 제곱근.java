import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static long N;

    static Deque<Integer> deque = new ArrayDeque<>();

    static String[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Long.parseLong(br.readLine());

        long sqrt = (long) Math.sqrt(N);
        
        if (sqrt * sqrt < N) {
            sqrt++;
        }

        System.out.println(sqrt);
    }
}