import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int current = Integer.parseInt(br.readLine());

            set.add(current % 42);
        }

        System.out.println(set.size());
    }
}