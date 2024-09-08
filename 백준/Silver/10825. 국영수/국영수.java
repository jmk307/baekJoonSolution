import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    static String student, korean, english, math;
    static String[][] matrix;
    static String[] students;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        matrix = new String[N][4];
        students = new String[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            student = st.nextToken();
            korean = st.nextToken();
            english = st.nextToken();
            math = st.nextToken();
            
            matrix[i][0] = student;
            matrix[i][1] = korean;
            matrix[i][2] = english;
            matrix[i][3] = math;
        }
        
        Arrays.sort(matrix, (e1, e2) -> {
            if ((e1[1].equals(e2[1])) && (e1[2].equals(e2[2])) && (e1[3].equals(e2[3]))) {
                return e1[0].compareTo(e2[0]);
            }
            
            if ((e1[1].equals(e2[1])) && (e1[2].equals(e2[2]))) {
                return Integer.parseInt(e2[3]) - Integer.parseInt(e1[3]);
            }
            
            if (e1[1].equals(e2[1])) {
                return Integer.parseInt(e1[2]) - Integer.parseInt(e2[2]);
            } else {
                return Integer.parseInt(e2[1]) - Integer.parseInt(e1[1]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            System.out.println(matrix[i][0]);
        }
    }
}