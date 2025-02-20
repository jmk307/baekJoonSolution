import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<int[]> list = new ArrayList<>();
        
        int condition = check(ext);
        
        for (int[] current : data) {
            if (current[condition] < val_ext) {
                list.add(current);
            }
        }
        
        final int c = check(sort_by);
        
        Collections.sort(list, (e1, e2) -> {
            return e1[c] - e2[c];
        });
        
        answer = new int[list.size()][list.get(0).length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static int check(String ext) {
        if (ext.equals("code")) {
            return 0;
        } else if (ext.equals("date")) {
            return 1;
        } else if (ext.equals("maximum")) {
            return 2;
        } else {
            return 3;
        }
    }
}