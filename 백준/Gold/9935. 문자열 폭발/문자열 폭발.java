import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T, N;
    static int count = 0;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static char[] matrix, explode;
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> remain = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        matrix = br.readLine().toCharArray();
        explode = br.readLine().toCharArray();

        for (int i = matrix.length - 1; i >= 0; i--) {
            stack.push(matrix[i]);
        }

        while (true) {
            boolean isValid = false;
            while (!stack.isEmpty()) {
                if (stack.peek() == explode[0]) {
                    boolean isAnswer = true;
                    boolean isCountless = false;
                    for (int i = 0; i < explode.length; i++) {
                        if (stack.isEmpty()) {
                            isCountless = true;
                            break;
                        }
                        char now = stack.pop();
                        remain.push(now);
                        if (now != explode[i]) {
                            isAnswer = false;
                            break;
                        }
                    }

                    if (isCountless) {
                        isValid = false;
                        break;
                    } else if (isAnswer) {
                        isValid = true;
                        for (int i = 0; i < explode.length; i++) {
                            remain.pop();
                        }

                        for (int i = 0; i < explode.length; i++) {
                            if (remain.isEmpty()) {
                                break;
                            }
                            stack.push(remain.pop());
                        }
                    } else {
                        stack.push(remain.pop());
                    }
                } else {
                    remain.push(stack.pop());
                }
            }

            if (!isValid) {
                if (remain.isEmpty()) {
                    sb.append("FRULA");
                } else {
                    for (char i : remain) {
                        sb.append(i);
                    }
                    for (char i : stack) {
                        sb.append(i);
                    }
                }

                break;
            } else {
                while (!remain.isEmpty()) {
                    stack.push(remain.pop());
                }
            }
        }

        System.out.println(sb);
    }
}