import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static int N;
    
    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int target = Integer.parseInt(st.nextToken());
            
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            
            matrix[i][0] = target;
            matrix[i][1] = strike;
            matrix[i][2] = ball;
        }
        
        
        int count = 0;
        for (int i = 111; i <= 999; i++) {
            int current = i;
            
            String[] arrays = String.valueOf(current).split("");
            
            int a = current / 100;
            int b = (current % 100) / 10;
            int c = (current % 100) % 10;
            
            if (a != 0 && b != 0 && c != 0 && a != b && b != c && c != a) {
                boolean isCount = true;
                for (int j = 0; j < N; j++) {
                    int now = matrix[j][0];
                    
                    int currentStrike = 0;
                    int currentBall = 0;
                    
                    String[] targets = String.valueOf(now).split("");
                    for (int x = 0; x < 3; x++) {
                        String target = arrays[x];
                        
                        for (int y = 0; y < 3; y++) {
                            if (targets[y].equals(target)) {
                                if (x == y) {
                                    currentStrike++;
                                } else {
                                    currentBall++;
                                }
                            }
                        }
                    }
                    
                    if (currentStrike == matrix[j][1] && currentBall == matrix[j][2]) {
                        isCount = true;
                    } else {
                        isCount = false;
                        break;
                    }
                }
                
                if (isCount) {
                    count++;
                }
            }
            
            
        }
        
        System.out.println(count);
    }
}