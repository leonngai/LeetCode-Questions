class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 1)
            return new int[0][0];
        
        int[][] answer = new int[n][n];
        int i = 1, topbound = 0, leftbound = 0, bottombound = n - 1, rightbound = n - 1;
        
        while (topbound <= bottombound && leftbound <= rightbound) {
            for (int left = leftbound; left <= rightbound; left++) 
                answer[topbound][left] = i++;
                
            topbound++;
            
            for (int top = topbound; top <= bottombound; top++)
                answer[top][rightbound] = i++;
            
            rightbound--;
            
            for (int right = rightbound; right >= leftbound; right--)
                answer[bottombound][right] = i++;
            
            bottombound--;
            
            for (int bottom = bottombound; bottom >= topbound; bottom--)
                answer[bottom][leftbound] = i++;
            
            leftbound++;
            
        }
        
        return answer;
        
    }
}
