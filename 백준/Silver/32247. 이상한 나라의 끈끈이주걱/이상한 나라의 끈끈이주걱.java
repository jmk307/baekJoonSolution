import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    static int N, M, c, x, h;

    static List<Long> list = new ArrayList<>();
    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            matrix[i][0] = c;
            matrix[i][1] = x;
            matrix[i][2] = h;
        }
        Arrays.sort(matrix, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        int currentIdx = 0;
        int currentHeight = 0;
        boolean isAnswer = true;
        for (int i = 0; i < M; i++) {
            int gap = matrix[i][1] - currentIdx;

            if (matrix[i][0] == 0 && currentHeight <= matrix[i][2]) {
                currentHeight = (matrix[i][2] + 1);
            } else {
                currentHeight -= gap;
                if (matrix[i][0] == 1) {
                    if (currentHeight >= matrix[i][2]) {
                        isAnswer = false;
                        break;
                    }
                } else {
                    if (currentHeight <= matrix[i][2]) {
                        currentHeight = matrix[i][2] + 1;
                    }
                }
            }

            currentIdx = matrix[i][1];
        }

        if (isAnswer && 0 < currentHeight && N - currentIdx < Math.abs(currentHeight)) {
            isAnswer = false;
        } 
        
        if (isAnswer) {
            System.out.println("stay");
        } else {
            System.out.println("adios");
        }
    }
}