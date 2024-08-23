import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        String[] arrays = input.split("");

        List<Integer> list = new ArrayList<>();

        for (String i : arrays) {
            list.add(Integer.parseInt(i));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i : list) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}