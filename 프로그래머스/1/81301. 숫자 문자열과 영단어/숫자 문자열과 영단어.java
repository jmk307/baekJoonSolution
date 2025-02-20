import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        
        String result = "";
        String current = "";
        for (char i : s.toCharArray()) {
            if (Character.isDigit(i)) {
                result += String.valueOf(i);
            } else {
                current += String.valueOf(i);
                
                if (map.containsKey(current)) {
                    result += map.get(current);
                    current = "";
                }
            }
        }
        
        return answer = Integer.parseInt(result);
    }
}