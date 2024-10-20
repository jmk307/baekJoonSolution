import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        
        for (int i : list) {
            System.out.println(i);
        }
    }
}
