class Solution {
    /*
        Process:
        1) Like the previous best time to buy and sell stock we continually try to find a min and maximum
        2) We buy when we find the next local minimum
        3) We sell when we find the next local maximum
        4) We continually update the profit with the sell price - buy price
        
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
   public int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}
