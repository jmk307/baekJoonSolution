import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N];
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        
        
        for (int i = 0; i < N; i++) {
            matrix[i] = list.get(i);
        }
        
        int target = 0;
        int start = 0;
        int end = matrix.length - 1;
        for (int i = 0; i < N; i++) {
            target += (int) Math.abs(matrix[(start + end) / 2] - matrix[i]);
        }
        
        while (start <= end) {
            int midi = (start + end) / 2;
            int midv = 0;
            for (int i = 0; i < N; i++) {
                midv += (int) Math.abs(matrix[midi] - matrix[i]);
            }
            
            if (midv <= target) {
                target = midv;
                end = midi - 1;
            } else {
                start = midi + 1;
            }
        }
        
        System.out.println(matrix[start]);
    }
}