import java.lang.*;
import java.util.*;
import java.io.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        StringTokenizer st;
        for (String i : terms) {
            st = new StringTokenizer(i);
            
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            
            map.put(a, b);
        }
        
        int totalNow = Integer.parseInt(today.replace(".", ""));
        
        int count = 1;
        for (String i : privacies) {
            st = new StringTokenizer(i);
            
            String current = st.nextToken();
            int value = map.get(st.nextToken());
            
            int totalStartDate = Integer.parseInt(current.replace(".", ""));
            
            int[] startDate = new int[3];
            st = new StringTokenizer(current, ".");
            startDate[0] = Integer.parseInt(st.nextToken());
            startDate[1] = Integer.parseInt(st.nextToken());
            startDate[2] = Integer.parseInt(st.nextToken());
            
            int[] expiredDate = new int[3];
            expiredDate[0] = startDate[0];
            expiredDate[1] = startDate[1] + value;
            expiredDate[2] = startDate[2];
            
            if (expiredDate[1] >= 12) {
                while (true) {
                    if (expiredDate[1] <= 12) {
                        break;
                    }
                    
                    expiredDate[1] -= 12;
                    expiredDate[0]++;
                }
            }
            expiredDate[2]--;
            
            String a = String.valueOf(expiredDate[0]);
            if (expiredDate[0] < 10) {
                a = "0" + expiredDate[0];
            }
            
            String b = String.valueOf(expiredDate[1]);
            if (expiredDate[1] < 10) {
                b = "0" + expiredDate[1];
            }
            
            String c = String.valueOf(expiredDate[2]);
            if (expiredDate[2] < 10) {
                c = "0" + expiredDate[2];
            }
            
            int totalExpiredDate = Integer.parseInt(a + b + c);
            
            if (totalNow < totalStartDate || totalNow > totalExpiredDate) {
                list.add(count);
            }
            
            count++;
        }
        
        answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}