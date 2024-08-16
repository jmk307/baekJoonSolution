import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, A, B, C;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] matrix = new int[] {A, B, C};
        
        int answer = 0;
        for (int current : matrix) {
            if (current < N) {
                answer += current;
            } else {
                answer += N;
            }
        }

        System.out.println(answer);
    }
}