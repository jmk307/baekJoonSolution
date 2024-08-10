import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();

    static List<Double> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("999")) {
                break;
            }

            list.add(Double.parseDouble(input));
        }

        for (int i = 1; i < list.size(); i++) {
            System.out.printf("%.2f", list.get(i) - list.get(i - 1));
            System.out.println();
        }
    }
}