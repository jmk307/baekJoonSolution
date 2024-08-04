import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> array = new ArrayList<>(list);
        Collections.sort(array);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (!map.containsKey(array.get(i))) {
                map.put(array.get(i), count);
                count++;
            }
        }
        
        for (int i : list) {
            sb.append(map.get(i)).append(" ");
        }
        
        System.out.println(sb);
    }
}