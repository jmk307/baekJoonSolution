import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, T;

    static Stack<Node> stack = new Stack<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            if (input == 0) {
                if (!stack.isEmpty()) {
                    Node now = stack.pop();

                    if (now.t - 1 == 0) {
                        sum += now.a;
                    } else {
                        stack.push(new Node(now.a, now.t - 1));
                    }
                }
            } else {
                A = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());

                if (T - 1 == 0) {
                    sum += A;
                } else {
                    stack.push(new Node(A, T - 1));
                }
            }
        }

        System.out.println(sum);
    }
}

class Node {
    int a;

    int t;

    public Node(int a, int t) {
        this.a = a;
        this.t = t;
    }
}