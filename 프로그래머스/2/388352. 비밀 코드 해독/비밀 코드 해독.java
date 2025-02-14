import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

class Solution {
    static int[] result = new int[5];
    static boolean[] visited;
    static int total = 0;
    
    static int N = 0;
    static int[][] q;
    static int[] ans;
    
    public int solution(int n, int[][] matrix, int[] t) {
        int answer = 0;
        N = n;
        visited = new boolean[N + 1];
        q = matrix;
        ans = t;
        
        backTracking(0, 0);
        
        return answer = total;
    }
    
    static void backTracking(int depth, int prev) {
        if (depth == 5) {
            boolean isAnswer = true;
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                int[] now = q[i];
                
                for (int j = 0; j < now.length; j++) {
                    int current = result[j];
                    for (int k = 0; k < now.length; k++) {
                        if (current == now[k]) {
                            count++;
                        }
                    }
                }
                
                if (count != ans[i]) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                total++;
            }
            
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && i > prev) {
                visited[i] = true;
                result[depth] = i;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}