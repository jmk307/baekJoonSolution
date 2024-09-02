import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, M;
    
    static Integer[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new Integer[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = Arrays.asList(matrix);
        
        M = Integer.parseInt(br.readLine());
        
        int start = 1;
        int end = Collections.max(list);
        
        List<Integer> answer = new ArrayList<>();
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int sum = 0;
            for (int i : list) {
                if (i >= mid) {
                    sum += mid;
                } else {
                    sum += i;
                }
            }
            
            if (sum <= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer.add(end);
            }
        }
        
        System.out.println(end);
    }
}