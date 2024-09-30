import java.util.*;
import java.io.*;

public class Main {
    static int T, I, startX, startY, endX, endY;
    static int count = 0;
    
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            
            matrix = new int[I][I];
            visited = new boolean[I][I];
            count = 0;
            
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            
            BFS(startX, startY);
        }
    }
    
    static void BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {a, b});
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            
            if (now[0] == endX && now[1] == endY) {
                System.out.println(matrix[now[0]][now[1]]);
                break;
            }
            
            for (int i = 0; i < 8; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                
                if (x >= 0 && y >= 0 && x < I && y < I) {
                    if (!visited[x][y]) {
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                        que.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
