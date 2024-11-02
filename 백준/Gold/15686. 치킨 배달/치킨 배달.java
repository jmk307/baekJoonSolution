import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    static int result = Integer.MAX_VALUE;
    
    static int[][] matrix;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        matrix = new int[N + 1][N + 1];
        
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                
                if (matrix[i][j] == 1) {
                    home.add(new int[] {i, j});
                } else if (matrix[i][j] == 2) {
                    chicken.add(new int[] {i, j});
                }
            }
        }
        
        backTracking(0, new ArrayList<int[]>());
        
        System.out.println(result);
    }
    
    static void backTracking(int depth, List<int[]> sum) {
        if (depth == chicken.size()) {
            if (sum.size() > 0 && sum.size() <= M) {
                int a = 0;
                
                for (int[] i : home) {
                    int total = Integer.MAX_VALUE;
                    for (int[] j : sum) {
                        int now = 0;
                        now += (int) Math.abs(j[0] - i[0]);
                        now += (int) Math.abs(j[1] - i[1]);
                        
                        total = Math.min(now, total);
                    }
                    
                    a += total;
                }
                
                result = Math.min(a, result);
            }
            
            return;
        }
        
        
        List<int[]> newSum = new ArrayList<>(sum);
        newSum.add(chicken.get(depth));
        
        backTracking(depth + 1, newSum);
        backTracking(depth + 1, sum);
    }
}
