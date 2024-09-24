import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, K, P, W;

    static int[] matrix, answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = new int[12];

        PriorityQueue<Integer>[] arrayPq = new PriorityQueue[12];

        for (int i = 1; i <= 11; i++) {
            arrayPq[i] = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arrayPq[P].add(W);
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= 11; j++) {
                if (!arrayPq[j].isEmpty()) {
                    int current = arrayPq[j].peek();

                    if (current > answer[j]) {
                        arrayPq[j].add(answer[j]);

                        answer[j] = arrayPq[j].poll();
                    }
                }

                if (answer[j] >= 1) {
                    answer[j] = answer[j] - 1;
                }

                if (!arrayPq[j].isEmpty()) {
                    int current = arrayPq[j].peek();

                    if (current > answer[j]) {
                        arrayPq[j].add(answer[j]);

                        answer[j] = arrayPq[j].poll();
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            sum += answer[i];
        }

        System.out.println(sum);
    }
}