import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Stack<String> stack = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] arrays = br.readLine().split("");

        boolean isAnswer = true;
        for (String i : arrays) {
            if (i.equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else if (i.equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            isAnswer = false;
        }

        if (isAnswer) {
            stack = new Stack<>();
            for (String i : arrays) {
                if (i.equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        int sum = 0;
                        while (!stack.peek().equals("(")) {
                            sum += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        sum *= 2;

                        stack.push(String.valueOf(sum));
                    }
                } else if (i.equals("]")) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int sum = 0;
                        while (!stack.peek().equals("[")) {
                            sum += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        sum *= 3;

                        stack.push(String.valueOf(sum));
                    }
                } else {
                    stack.push(i);
                }
            }

            int answer = 0;
            while (!stack.isEmpty()) {
                answer += Integer.parseInt(stack.pop());
            }

            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }
}