import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        String word = "";

        while (word != null) {
            try {
                word = st.nextToken();
                sum++;
            } catch (NoSuchElementException e) {
                break;
            }
        }

        System.out.println(sum);
    }
}