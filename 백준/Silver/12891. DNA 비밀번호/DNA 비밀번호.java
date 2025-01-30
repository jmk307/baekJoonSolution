import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int S, P;
    static int count = 0;
    static String[] input;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[] answer, result;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        input = br.readLine().split("");
        visited = new boolean[S];
        answer = new int[4];
        result = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            if (input[i].equals("A")) {
                result[0]++;
            } else if (input[i].equals("C")) {
                result[1]++;
            } else if (input[i].equals("G")) {
                result[2]++;
            } else if (input[i].equals("T")) {
                result[3]++;
            }
        }

        boolean isAnswer = true;
        for (int i = 0; i < 4; i++) {
            if (result[i] < answer[i]) {
                isAnswer = false;
                break;
            }
        }

        if (isAnswer) {
            count++;
        }

        for (int i = 1; i <= S - P; i++) {
            if (input[i-1].equals("A")) {
                result[0]--;
            } else if (input[i-1].equals("C")) {
                result[1]--;
            } else if (input[i-1].equals("G")) {
                result[2]--;
            } else if (input[i-1].equals("T")) {
                result[3]--;
            }

            if (input[i + P - 1].equals("A")) {
                result[0]++;
            } else if (input[i + P - 1].equals("C")) {
                result[1]++;
            } else if (input[i + P - 1].equals("G")) {
                result[2]++;
            } else if (input[i + P - 1].equals("T")) {
                result[3]++;
            }

            isAnswer = true;
            for (int j = 0; j < 4; j++) {
                if (result[j] < answer[j]) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                count++;
            }
        }

        System.out.println(count);
    }
}