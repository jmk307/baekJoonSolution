class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] result = new int[players.length];

        for (int i = 0; i < 24; i++) {
            if (players[i] / m == 0) {
                continue;
            }

            if (result[i] >= players[i] / m) {
                continue;
            }

            int gap = players[i] / m - result[i];
            answer += gap;

            int end = Math.min(24, i + k);

            for (int j = i; j < end; j++) {
                result[j] += gap;
            }
        }

        return answer;
    }
}