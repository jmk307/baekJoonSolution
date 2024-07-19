import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] matrix;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String str = br.readLine();
            if (str.equals("0 0 0")) {
                break;
            }
            st = new StringTokenizer(str);

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            matrix = new int[]{A, B, C};
            Arrays.sort(matrix);

            if (matrix[0] * matrix[0] + matrix[1] * matrix[1] == matrix[2] * matrix[2]) {
                answer.add("right");
            } else {
                answer.add("wrong");
            }
        }

        answer.forEach(System.out::println);
    }
}