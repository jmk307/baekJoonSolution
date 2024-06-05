import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] arr = input.toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';
        }
        System.out.println(sum);
    }
}