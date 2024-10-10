import java.util.*;
import java.io.*;

public class Main {
    static int N, M, L, R;
    
    static int[] A;
    static int[] answer;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        A = new int[N + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            map.put(A[i], i);
        }
        
        M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            
            answer = A.clone();
            List<Integer> list = new ArrayList<>();
            
            for (int i = L; i <= R; i++) {
                list.add(map.get(i));
            }
            Collections.sort(list);
            
            int start = L;
            for (int i = 0; i < list.size(); i++) {
                answer[list.get(i)] = L;
                L++;
            }
            
            for (int i = 1; i < N + 1; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
