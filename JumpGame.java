class Solution {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        
        memo[nums.length - 1] = true;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (j + i >= nums.length)
                    break;
                else if (memo[j + i]) {
                    memo[i] = true;
                    break;
                }
            }
        }
        
        return memo[0];
    }
}
