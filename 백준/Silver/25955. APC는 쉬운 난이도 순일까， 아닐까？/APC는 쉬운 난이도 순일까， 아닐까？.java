import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static String[] matrix, answer;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new String[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = st.nextToken();
        }
        
        answer = matrix.clone();
        
        List<String> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                String current = matrix[j].substring(0, 1);
                String next = matrix[j + 1].substring(0, 1);
                
                if (current.equals("D")) {
                    if (next.equals("B") || next.equals("S") || next.equals("G") || next.equals("P")) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    } else if (current.equals(next) && Integer.parseInt(matrix[j].substring(1)) < Integer.parseInt(matrix[j + 1].substring(1))) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    }
                } else if (current.equals("P")) {
                    if (next.equals("B") || next.equals("S") || next.equals("G")) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    } else if (current.equals(next) && Integer.parseInt(matrix[j].substring(1)) < Integer.parseInt(matrix[j + 1].substring(1))) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    }
                } else if (current.equals("G")) {
                    if (next.equals("B") || next.equals("S")) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    } else if (current.equals(next) && Integer.parseInt(matrix[j].substring(1)) < Integer.parseInt(matrix[j + 1].substring(1))) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    }
                } else if (current.equals("S")) {
                    if (next.equals("B")) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    } else if (current.equals(next) && Integer.parseInt(matrix[j].substring(1)) < Integer.parseInt(matrix[j + 1].substring(1))) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    }
                } else if (current.equals("B")) {
                    if (current.equals(next) && Integer.parseInt(matrix[j].substring(1)) < Integer.parseInt(matrix[j + 1].substring(1))) {
                        String temp =  matrix[j];
                        matrix[j] = matrix[j + 1];
                        matrix[j + 1] = temp;
                    }
                }
            }
        }
        
        boolean isAnswer = true;
        for (int i = 0; i < N; i++) {
            if (!answer[i].equals(matrix[i])) {
                isAnswer = false;
                list.add(matrix[i]);
            }
        }
        
        if (isAnswer) {
            System.out.println("OK");
        } else {
            sb.append("KO").append("\n")
                .append(list.get(0)).append(" ").append(list.get(1));
                
            System.out.println(sb);
        }
    }
}
