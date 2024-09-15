import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String input;
    static String[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();

        int[] alphaCount = new int[26];

        for (char c : input.toCharArray()) {
            alphaCount[c - 'A']++;
        }

        int oddCount = 0;
        String oddString = "";
        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] % 2 == 1) {
                oddCount++;
                oddString = String.valueOf((char) (i + 'A'));
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            answer = new String[input.length()];

            int idx = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphaCount[i] / 2; j++) {
                    answer[idx] = String.valueOf((char) (i + 'A'));
                    answer[input.length() - idx - 1] = String.valueOf((char) (i + 'A'));

                    idx++;
                }
            }

            if (oddCount == 1) {
                answer[input.length() / 2] = oddString;
            }

            for (String i : answer) {
                sb.append(i);
            }
            sb.append("\n");

            System.out.println(sb);
        }
    }
}