import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int T, n;
    static String p;

    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            String[] a = input.substring(1, input.length() - 1).split(",");
            matrix = new int[n];

            for (int i = 0; i < n; i++) {
                matrix[i] = Integer.parseInt(a[i]);
            }

            int start = 0;
            int end = n - 1;
            boolean isReverse = false;
            boolean isAnswer = true;

            String[] P = p.split("");
            for (String current : P) {
                if (current.equals("R")) {
                    isReverse = !isReverse;

                    int x = start;
                    int y = end;

                    start = y;
                    end = x;
                } else {
                    if (isReverse) {
                        if (start < end) {
                            isAnswer = false;
                            break;
                        }
                        start--;
                    } else {
                        if (start > end) {
                            isAnswer = false;
                            break;
                        }
                        start++;
                    }
                }
            }

            if (!isAnswer) {
                sb.append("error").append("\n");
            } else {
                if (!isReverse) {
                    sb.append("[");
                    for (int i = start; i <= end; i++) {
                        if (i == end) {
                            sb.append(matrix[i]);
                        } else {
                            sb.append(matrix[i]).append(",");
                        }
                    }
                    sb.append("]");
                } else {
                    sb.append("[");
                    for (int i = start; i >= end; i--) {
                        if (i == end) {
                            sb.append(matrix[i]);
                        } else {
                            sb.append(matrix[i]).append(",");
                        }
                    }
                    sb.append("]");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}