class Solution {
    // DP solution
    public int minCostClimbingStairs(int[] cost) {
        int sum = 0;
        int twoStepBefore = cost[0], oneStepBefore = cost[1];
        
        for(int i = 2; i < cost.length; i++){
            sum = Math.min(twoStepBefore,oneStepBefore) + cost[i];
            twoStepBefore = oneStepBefore;
            oneStepBefore = sum;
        }
        
        return Math.min(oneStepBefore,twoStepBefore);
    }
}

    /* Brute Force
        int min = Integer.MAX_VALUE;
        public int minCostClimbingStairs(int[] cost) {
            helper(cost, 0, 0, cost.length);
            helper(cost, 1, 0, cost.length);

            return min;
        }

        public void helper(int[] cost, int index, int sum, int length) {
            if (index >= length) {
                min = Math.min(min, sum);
                return;
            }

            helper(cost, index + 1, sum + cost[index], length);
            helper(cost, index + 2, sum + cost[index], length);
        }
    */
