import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static Stack<Integer> stack = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int current = Integer.parseInt(st.nextToken());

            if (current == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (current == 2) {
                if (stack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (current == 3) {
                System.out.println(stack.size());
            } else if (current == 4) {
                if (stack.empty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (current == 5) {
                if (stack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}