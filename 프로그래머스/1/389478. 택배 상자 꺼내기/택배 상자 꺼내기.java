import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

class Solution {
    static int r, c;
    static int[][] matrix;
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        if (n % w == 0) {
            r = n / w;
        } else {
            r = n / w + 1;
        }
        c = w;
        
        matrix = new int[r][c];
        
        int temp = 1;
        for (int i = 0; i < r; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = temp;
                    temp++;
                }
            } else {
                for (int j = c - 1; j >= 0; j--) {
                    matrix[i][j] = temp;
                    temp++;
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i < c; i++) {
            int count = 0;
            for (int j = r - 1; j >= 0; j--) {
                if (matrix[j][i] <= n) {
                    count++;
                }
                
                if (matrix[j][i] == num) {
                    total = count;
                    break;
                }
            }
        }
        
        
        return answer = total;
    }
}