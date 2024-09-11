import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;

    static int[] matrix;

    static Stack<Integer> stack = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int next = 1;
        boolean isAnswer = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != next) {
                if (!stack.empty()) {
                    if (stack.peek() == next) {
                        stack.pop();
                        next++;

                        if (matrix[i] == next) {
                            next++;
                        }
                    } else {
                        stack.push(matrix[i]);
                    }
                } else {
                    stack.push(matrix[i]);
                }
            } else {
                next++;

                if (!stack.empty()) {
                    while (true) {
                        if (stack.empty() || stack.peek() != next) {
                            break;
                        }

                        if (stack.peek() == next) {
                            stack.pop();
                            next++;
                        }
                    }

                }
            }
        }

        if (!stack.empty()) {
            while (!stack.empty()) {
                int now = stack.pop();

                if (now != next) {
                    isAnswer = false;
                    break;
                }

                next++;
            }
        }

        if (isAnswer) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}