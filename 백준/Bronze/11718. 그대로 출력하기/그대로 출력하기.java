import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int A, B;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = "";
        while ((input = br.readLine()) != null) {
            if (input == "") {
                break;
            }

            System.out.println(input);
        }
    }
}