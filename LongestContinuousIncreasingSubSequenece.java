class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        
        int ans = 1, count = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                
                ans = Math.max(ans, count);
            }
            else {
                count = 1;  
            }
        }
        
        return ans;
                
    }
    
}
