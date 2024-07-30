import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int S = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            int x = 0;

            if (input.equals("add")
                    || input.equals("remove")
                    || input.equals("check")
                    || input.equals("toggle")) {
                x = Integer.parseInt(st.nextToken());
            }

            solve(input, x);
        }

        System.out.println(sb);
    }

    static void solve(String input, int x) {
        if (input.equals("add")) {
            S |= (1 << x);
        }

        if (input.equals("remove")) {
            S &= ~(1 << x);
        }

        if (input.equals("check")) {
            sb.append((S & (1 << x)) != 0 ? 1 : 0).append('\n');
        }

        if (input.equals("toggle")) {
            S ^= (1 << x);
        }

        if (input.equals("all")) {
            S = (1 << 21) - 1;
        }

        if (input.equals("empty")) {
            S = 0;
        }
    }
}