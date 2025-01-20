import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    /*static int[] dx = {0, 1, 0, -1, 2, 2};
    static int[] dy = {1, 0, -1, 0, -1, 1};*/

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] matrix, replace;
    static List<Long> list = new ArrayList<>();
    static Map<Long, String> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String a = br.readLine();
        String b = br.readLine();

        String[] arrays = a.split("");

        int count = 0;
        int index = 0;
        while (true) {
            boolean isAnswer = false;

            if (index + b.length() > a.length()) {
                break;
            } else {
                if (a.substring(index, index + b.length()).equals(b)) {
                    isAnswer = true;
                    count++;
                }
            }

            if (isAnswer) {
                index += b.length();
            } else {
                index++;
            }
        }

        System.out.println(count);
    }
}