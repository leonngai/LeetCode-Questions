class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        //calculate sum to left 
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        //res = [1 1 2 6]
        
        //calculate sum to right while updating result at the same time
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r = r * nums[i];
        }
        
        return res;
    }
}
