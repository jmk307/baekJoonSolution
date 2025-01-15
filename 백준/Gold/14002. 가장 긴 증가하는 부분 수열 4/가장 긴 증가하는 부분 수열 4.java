import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix;
    static int[] dp;
    static ArrayList<Integer>[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N];
        dp = new int[N];
        answer = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            answer[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(matrix[i]);
            answer[i] = list;
            
            for (int j = 0; j < i; j++) {
                if (matrix[j] < matrix[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                    if (dp[i] == dp[j] + 1) {
                        ArrayList<Integer> current = new ArrayList<>(answer[j]);
                        current.add(matrix[i]);
                        
                        answer[i] = current;
                    }
                }
            }
            
            max = Math.max(dp[i], max);
            
            if (dp[i] == max) {
                idx = i;
            }
        }
        
        sb.append(answer[idx].size()).append("\n");
        for (int i : answer[idx]) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
}