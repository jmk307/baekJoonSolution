import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int N;
    static boolean isResult = false;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] matrix;
    static List<int[]> teachers = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String now = st.nextToken();

                if (now.equals("S")) {
                    matrix[i][j] = 1;
                } else if (now.equals("T")) {
                    matrix[i][j] = 2;
                    teachers.add(new int[] {i, j});
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        backTracking(0, 0, 0);

        if (isResult) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void backTracking(int a, int b, int depth) {
        if (depth == 3) {
            boolean isAnswer = true;
            for (int[] t : teachers) {
                // 상
                for (int i = t[0] - 1; i >= 0; i--) {
                    if (matrix[i][t[1]] == 1) {
                        isAnswer = false;
                        break;
                    } else if (matrix[i][t[1]] == 3) {
                        break;
                    }
                }

                // 하
                for (int i = t[0] + 1; i < N; i++) {
                    if (matrix[i][t[1]] == 1) {
                        isAnswer = false;
                        break;
                    } else if (matrix[i][t[1]] == 3) {
                        break;
                    }
                }

                // 좌
                for (int i = t[1] - 1; i >= 0; i--) {
                    if (matrix[t[0]][i] == 1) {
                        isAnswer = false;
                        break;
                    } else if (matrix[t[0]][i] == 3) {
                        break;
                    }
                }

                // 우
                for (int i = t[1] + 1; i < N; i++) {
                    if (matrix[t[0]][i] == 1) {
                        isAnswer = false;
                        break;
                    } else if (matrix[t[0]][i] == 3) {
                        break;
                    }
                }
            }

            if (isAnswer) {
                isResult = true;
            }

            return;
        }

        for (int i = a; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == a && j < b) continue;

                if (matrix[i][j] == 0) {
                    matrix[i][j] = 3;
                    backTracking(a, b + 1, depth + 1);
                    matrix[i][j] = 0;
                }
            }
        }
    }
}