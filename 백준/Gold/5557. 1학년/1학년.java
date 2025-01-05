import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static long max = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] matrix;
	static long[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][21];
        matrix = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][matrix[0]] = 1;

        for (int i = 1; i < N; i++) {
            int now = matrix[i];

            for (int j = 0; j <= 20; j++) {
                if (dp[i-1][j] != 0) {
                    if (j - now >= 0) {
                        dp[i][j - now] += dp[i-1][j];
                    }

                    if (j + now <= 20) {
                        dp[i][j + now] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][matrix[N-1]]);
	}
}
