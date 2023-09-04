import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();

		for (char c : input.toCharArray()) {
			if (Character.isDigit(c) || c == ' ') {
				sb.append(c);
			} else {
				if (Character.isUpperCase(c)) {
					int result = (int) c - 65 + 13;
					if (result > 25) {
						sb.append((char)(result - 26 + 65));
					} else {
						sb.append((char)(result + 65));
					}
				} else {
					int result = (int) c - 97 + 13;
					if (result > 25) {
						sb.append((char)(result - 26 + 97));
					} else {
						sb.append((char)(result + 97));
					}
				}
			}
		}
		System.out.println(sb);
	}
}