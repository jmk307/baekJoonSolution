import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int a = schedules[i] / 100;
            int b = schedules[i] % 100;
            b += 10;
            
            if (b >= 60) {
                b -= 60;
                a++;
            }
            
            int now = a * 100 + b;
            
            boolean isAnswer = true;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((j + startday) % 7 == 6 || (j + startday) % 7 == 0) {
                    continue;
                }
                
                if (timelogs[i][j] > now) {
                    isAnswer = false;
                    break;
                }
            }
            
            if (isAnswer) {
                answer++;
            }
        }
        
        return answer;
    }
}