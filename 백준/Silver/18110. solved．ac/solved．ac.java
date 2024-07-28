import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int n;

    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        double m = 0.15 * n;
        double k = Math.round(m);
        int j = (int) k;

        int sum = 0;
        for (int i = j; i < list.size() - j; i++) {
            sum += list.get(i);
        }

        double count = n - 2*j;
        double doubleSum = (double) sum;
        int average = (int) Math.round(doubleSum / count);
        
        System.out.println(average);

    }
}