import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;

        System.out.println(input.charAt(index));
    }
}