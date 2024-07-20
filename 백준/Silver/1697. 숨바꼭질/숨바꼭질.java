import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] matrix = new int[1000001];;

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS(N));
    }

    static int BFS(int a) {
        Queue<Integer> que = new LinkedList<>();
        que.add(a);

        int n = 0;
        matrix[a] = 1;

        while (!que.isEmpty()) {
            n = que.poll();

            if (n == K)
            {
                return matrix[n] - 1;
            }

            if (n-1>=0 && matrix[n-1] == 0)
            {
                matrix[n-1] = matrix[n]+1;
                que.add(n-1);
            }
            if (n+1 <= 100000 && matrix[n+1] == 0)
            {
                matrix[n+1] = matrix[n]+1;
                que.add(n+1);
            }
            if (2*n <= 100000 && matrix[2*n] == 0)
            {
                matrix[2*n] = matrix[n] + 1;
                que.add(2*n);
            }
        }

        return -1;
    }
}