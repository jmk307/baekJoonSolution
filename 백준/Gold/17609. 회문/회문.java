import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int T;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] matrix = br.readLine().toCharArray();

            int start = 0;
            int end = matrix.length - 1;

            boolean isAnswer = true;
            int answer = 0;
            while (start <= end) {
                if (matrix[start] == matrix[end]) {
                    start++;
                    end--;
                } else {
                    if (matrix[start] == matrix[end-1]) {
                        int aStart = start;
                        int aEnd = end-1;

                        boolean isValid = true;
                        while (aStart <= aEnd) {
                            if (matrix[aStart] == matrix[aEnd]) {
                                aStart++;
                                aEnd--;
                            } else {
                                isValid = false;
                                break;
                            }
                        }

                        if (isValid) {
                            answer = 1;
                            break;
                        } else {
                            answer = 2;
                        }
                    }

                    if (matrix[start+1] == matrix[end]) {
                        int bStart = start+1;
                        int bEnd = end;

                        boolean isValid = true;
                        while (bStart <= bEnd) {
                            if (matrix[bStart] == matrix[bEnd]) {
                                bStart++;
                                bEnd--;
                            } else {
                                isValid = false;
                                isAnswer = false;
                                break;
                            }
                        }

                        if (isValid) {
                            answer = 1;
                        } else {
                            answer = 2;
                        }
                        break;
                    } else {
                        isAnswer = false;
                        break;
                    }
                }
            }

            if (isAnswer) {
                if (answer == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else {
                System.out.println(2);
            }
        }
    }
}