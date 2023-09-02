import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] result = new String[input.length()];

		for (int i = 0; i < input.length(); i++) {
			result[i] = input.substring(i, input.length());
		}

		List<String> newResult = new ArrayList<>(Arrays.asList(result));
		Collections.sort(newResult);
		
		for (int i = 0; i < newResult.size(); i++) {
			System.out.println(newResult.get(i));
		}
	}
}