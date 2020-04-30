class Solution {
    /*
        Taking the idea of the memo array, we only really care if we are able to make it to the last index that worked so there is no point in looping through every combination. If we are able to make it to the last index that can make it all the way to the end, then we update our last index
    */
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastIndex)
                lastIndex = i;
        }
        
        return lastIndex == 0;
    }
}
