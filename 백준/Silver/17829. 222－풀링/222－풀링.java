import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N, E, a, b, c, v1, v2;
    
    static int[][] matrix;
    static final int INF = 200000000;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(divideAndConquer(0, 0, N));
    }
    
    static int divideAndConquer(int x, int y, int size) {
        if (size == 2) {
            List<Integer> list = new ArrayList<>();
            list.add(matrix[x][y]);
            list.add(matrix[x+1][y]);
            list.add(matrix[x][y+1]);
            list.add(matrix[x+1][y+1]);
            Collections.sort(list);
        
            return list.get(2);
        }
        
        int a = divideAndConquer(x, y, size / 2);
        int b = divideAndConquer(x + size / 2, y, size / 2);
        int c = divideAndConquer(x, y + size / 2, size / 2);
        int d = divideAndConquer(x + size / 2, y + size / 2, size / 2);
        
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        Collections.sort(list);
        
        return list.get(2);
    }
}