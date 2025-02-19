import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "123";
        
        String[] arrays = pos.split(":");
        int current = Integer.parseInt(arrays[0]) * 60 + Integer.parseInt(arrays[1]);
        
        String[] starts = op_start.split(":");
        int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
        
        String[] ends = op_end.split(":");
        int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]);
        
        String[] totals = video_len.split(":");
        int total = Integer.parseInt(totals[0]) * 60 + Integer.parseInt(totals[1]);
        
        for (int i = 0; i < commands.length; i++) {
            String now = commands[i];
            
            if (current >= start && current <= end) {
                current = end;
            }
            
            if (now.equals("next")) {
                current += 10;
                
                if (total - current < 10) {
                    current = total;
                }
            } else {
                current -= 10;
                
                if (current < 10) {
                    current = 0;
                }
            }
            
            if (current >= start && current <= end) {
                current = end;
            }
        }
        
        int a = current / 60;
        int b = current % 60;
        
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        
        if (a < 10) {
            A = "0" + A;
        }
        
        if (b < 10) {
            B = "0" + B;
        }
        
        return answer = A + ":" + B;
    }
}