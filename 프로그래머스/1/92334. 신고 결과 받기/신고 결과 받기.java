import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> history = new HashMap<>();
        Map<String, Integer> historyCount = new HashMap<>();
        
        for (String i : id_list) {
            history.put(i, new ArrayList<String>());
        }
        
        for (String i : report) {
            String[] matrix = i.split(" ");
            
            if (history.get(matrix[0]).isEmpty()) {
                history.get(matrix[0]).add(matrix[1]);
                historyCount.put(matrix[1], historyCount.getOrDefault(matrix[1], 0) + 1);
            } else {
                if (!history.get(matrix[0]).contains(matrix[1])) {
                    history.get(matrix[0]).add(matrix[1]);
                    historyCount.put(matrix[1], historyCount.getOrDefault(matrix[1], 0) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            int count = 0;
            for (String j : history.get(id_list[i])) {
                if (historyCount.get(j) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}