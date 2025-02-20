import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = new int[set.size()];
        
        int index = 0;
        for (int i : set) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}