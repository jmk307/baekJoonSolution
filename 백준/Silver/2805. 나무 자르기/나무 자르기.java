import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static Long M;
    
    static List<Long> list = new ArrayList<>();
    static List<Long> answer = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        Long max = list.get(0);
        
        Long start = 0L;
        Long end = max;
        
        while (start <= end) {
            Long mid = (start + end) / 2;
            
            Long sum = 0L;
            for (Long tree : list) {
                if (tree - mid >= 0L) {
                    sum += (tree - mid);
                }
            }
            
            if (sum >= M) {
                start = mid + 1L;
                answer.add(mid);
            } else {
                end = mid - 1L;
            }
        }
        
        System.out.println(Collections.max(answer));
    }
}