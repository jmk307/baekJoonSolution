import java.util.*;
import java.io.*;

public class Main {
    static int A, B, C;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        
        for (int i : list) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
}
