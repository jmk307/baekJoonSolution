import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = st.nextToken();
            matrix[i][1] = st.nextToken();
        }

        Arrays.sort(matrix, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1].compareTo(e2[1]);
            } else {
                return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(matrix[i][0] + " " + matrix[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}