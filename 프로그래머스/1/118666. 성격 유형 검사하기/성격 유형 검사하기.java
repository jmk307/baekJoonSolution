import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char front = survey[i].charAt(0);
            char rear = survey[i].charAt(1);
            
            if (choices[i] < 4) {
                map.put(front, map.get(front) + (4 - choices[i]));
            } else if (choices[i] == 4) {
                continue;
            } else {
                map.put(rear, map.get(rear) + (choices[i] - 4));
            }
        }
        
        if (map.get('R') > map.get('T')) {
            answer += String.valueOf('R');
        } else if (map.get('R') == map.get('T')) {
            answer += String.valueOf('R');
        } else {
            answer += String.valueOf('T');
        }
        
        if (map.get('C') > map.get('F')) {
            answer += String.valueOf('C');
        } else if (map.get('C') == map.get('F')) {
            answer += String.valueOf('C');
        } else {
            answer += String.valueOf('F');
        }
        
        if (map.get('J') > map.get('M')) {
            answer += String.valueOf('J');
        } else if (map.get('J') == map.get('M')) {
            answer += String.valueOf('J');
        } else {
            answer += String.valueOf('M');
        }
        
        if (map.get('A') > map.get('N')) {
            answer += String.valueOf('A');
        } else if (map.get('A') == map.get('N')) {
            answer += String.valueOf('A');
        } else {
            answer += String.valueOf('N');
        }
        
        return answer;
    }
}