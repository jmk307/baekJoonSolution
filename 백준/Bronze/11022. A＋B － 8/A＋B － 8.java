import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, A, B;

    static int[] matrix;
    static int[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(A).append(" + ").append(B).append(" = ").append(A + B).append("\n");
        }

        System.out.println(sb);
    }
}