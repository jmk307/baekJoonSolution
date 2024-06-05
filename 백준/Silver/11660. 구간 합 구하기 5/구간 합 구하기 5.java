import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[][] arr = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] S = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
        }
    }
}