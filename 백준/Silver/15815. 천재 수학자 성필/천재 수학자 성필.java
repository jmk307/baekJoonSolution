import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String input;

	static Stack<Long> stack = new Stack<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		input = br.readLine();
		
		for (char i : input.toCharArray()) {
		    if (Character.isDigit(i)) {
		        stack.push(Long.parseLong(String.valueOf(i)));
		    } else {
		        if (i == '+') {
		            long now = Long.parseLong(String.valueOf(stack.pop())) + Long.parseLong(String.valueOf(stack.pop()));
		            stack.push(now);
		        } else if (i == '-') {
		            long a = Long.parseLong(String.valueOf(stack.pop()));
		            long b = Long.parseLong(String.valueOf(stack.pop()));
		            stack.push(b - a);
		        } else if (i == '*') {
		            long now = Long.parseLong(String.valueOf(stack.pop())) * Long.parseLong(String.valueOf(stack.pop()));
		            stack.push(now);
		        } else {
		            long a = Long.parseLong(String.valueOf(stack.pop()));
		            long b = Long.parseLong(String.valueOf(stack.pop()));
		            stack.push(b / a);
		        }
		    }
		}
		
		System.out.println(stack.pop());
	}
}
