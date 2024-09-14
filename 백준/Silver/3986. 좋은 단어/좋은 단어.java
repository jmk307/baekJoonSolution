import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();

            String[] arrays = br.readLine().split("");

            for (String current : arrays) {
                if (!stack.isEmpty() && stack.peek().equals(current)) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }

            if (stack.empty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}