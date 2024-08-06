import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("")) {
                break;
            }
            
            String[] arrays = input.split("");

            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].equals("i")) {
                    sb.append("e");
                } else if (arrays[i].equals("e")) {
                    sb.append("i");
                } else if (arrays[i].equals("I")) {
                    sb.append("E");
                } else if (arrays[i].equals("E")) {
                    sb.append("I");
                } else {
                    sb.append(arrays[i]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
	}
}
