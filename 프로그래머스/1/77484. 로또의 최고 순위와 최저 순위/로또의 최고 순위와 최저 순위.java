class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int countZero = 0;
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                countZero++;
                continue;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        count++;
                        break;
                    }
                }
            }
        }
        
        int[] rank = new int[7];
        rank[0] = rank[1] = 6;
        rank[2] = 5;
        rank[3] = 4;
        rank[4] = 3;
        rank[5] = 2;
        rank[6] = 1;
        
        answer[1] = rank[count];
        answer[0] = rank[count + countZero];
        
        return answer;
    }
}