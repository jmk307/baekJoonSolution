import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static String subject;

    static Double subjectPoint;

    static String grade;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Double sum = 0.0;
        Double count = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            subject = st.nextToken();
            subjectPoint = Double.parseDouble(st.nextToken());
            grade = st.nextToken();

            Double gradePoint = gradeToPoint(grade);
            if (!grade.equals("P")) {
                sum += subjectPoint * gradePoint;
                count += subjectPoint;
            }
        }

        System.out.println(sum / count);
    }

    static Double gradeToPoint(String grade) {
        Double result = 0.0;
        switch (grade) {
            case "A+":
                result = 4.5;
                break;
            case "A0":
                result = 4.0;
            break;
            case "B+":
                result = 3.5;
            break;
            case "B0":
                result = 3.0;
            break;
            case "C+":
                result = 2.5;
            break;
            case "C0":
                result = 2.0;
            break;
            case "D+":
                result = 1.5;
            break;
            case "D0":
                result = 1.0;
            break;
            case "F":
                result = 0.0;
            break;
        }

        return result;
    }
}