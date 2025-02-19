class Solution {
    static String[][] matrix;
    static int[] mats;
    static int max = -1;
    
    public int solution(int[] mat, String[][] park) {
        int answer = 0;
        
        matrix = park;
        mats = mat;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)  {
                check(i, j);
            }
        }
        
        return max;
    }
    
    static void check(int a, int b) {
        for (int now : mats) {
            boolean isValid = true;
            for (int i = a; i < a + now; i++) {
                for (int j = b; j < b + now; j++) {
                    if (i >= matrix.length || j >= matrix[i].length) {
                        isValid = false;
                        break;
                    }
                    
                    if (!matrix[i][j].equals("-1")) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            if (isValid) {
                max = Math.max(max, now);
            }
        }
    }
}