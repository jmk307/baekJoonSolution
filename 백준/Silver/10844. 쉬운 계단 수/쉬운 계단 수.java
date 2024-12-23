import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	static int N, M, a, b;
	static boolean isAnswer = false;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static long[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][10];

		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] += dp[i-1][1] % 1000000000;
				} else if (j < 9) {
					dp[i][j] += (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				} else {
					dp[i][j] += dp[i-1][8] % 1000000000;
				}
			}
		}

		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += dp[N][i] % 1000000000;
		}
		
		System.out.println(answer % 1000000000);
	}
}