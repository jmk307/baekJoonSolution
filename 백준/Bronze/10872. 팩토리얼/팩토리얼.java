import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp = Integer.parseInt(br.readLine());
		int result = factorial(temp);
		System.out.println(result);
	}

	public static int factorial(int n) {
		int result = 0;

		if (n == 0 || n == 1) {
			result = 1;
		} else {
			result = n * factorial(n-1);
		}

		return result;
	}
}