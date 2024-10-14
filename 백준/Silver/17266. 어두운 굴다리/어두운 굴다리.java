import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M;

    static int[] matrix;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        matrix = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 100000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (canLight(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
    
    static boolean canLight(int h) {
        int prev = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] - h <= prev) {
                prev = matrix[i] + h;
            } else {
                return false;
            }
        }
        
        return N - prev <= 0;
    }
}