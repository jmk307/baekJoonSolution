import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static Map<String, String> map = Map.of(
            "@", "a",
            "[", "c",
            "!", "i",
            ";", "j",
            "^", "n",
            "0", "o",
            "7", "t",
            "?", "w",
            "+", "v"
        );
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String result = input;
            
            result = result.replace("\\\\\'", "?");
            result = result.replace("\\\'", "+");
            
            int count = 0;
            String answer = "";
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == '@'
                    || result.charAt(j) == '['
                    || result.charAt(j) == '!'
                    || result.charAt(j) == ';'
                    || result.charAt(j) == '^'
                    || result.charAt(j) == '0'
                    || result.charAt(j) == '7'
                    || result.charAt(j) == '?'
                    || result.charAt(j) == '+') {
                        count++;
                        answer += map.get(String.valueOf(result.charAt(j)));
                } else {
                    answer += String.valueOf(result.charAt(j));
                }
            }
            
            if (count >= result.length() / 2.0) {
                System.out.println("I don't understand");
            } else {
                System.out.println(answer);
            }
        }
    }
}
