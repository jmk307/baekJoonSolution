import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String order = br.readLine();
		char[] chars = order.toCharArray();
		System.out.println(chars.length);
	}
}