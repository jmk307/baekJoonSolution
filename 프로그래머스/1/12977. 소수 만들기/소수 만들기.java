class Solution {
    static boolean[] isPrime = new boolean[10001];
    
    public int solution(int[] nums) {
        
        for (int i = 2; i <= 10000; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            for (int j = i * i; j <= 10000; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (isPrime[sum]) {
                        count++;
                    }
                }
            }
        }
        int answer = -1;

        return answer = count;
    }
}