class Solution {
    public int maxProfit(int[] prices) {
        //find max between min and max of the array going from left to right
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > max) {
                max = prices[i] - min;                
            }
        }
        return max;
    }
}
