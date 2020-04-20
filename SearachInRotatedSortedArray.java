class Solution {
    int index = -1;
    
    public int search(int[] nums, int target) {
        helper(nums, target, 0, nums.length - 1);
        return index;
    }
    
    public void helper(int[] nums, int target, int lo, int high) {
        if (lo > high || index != -1)
            return;
        
        int middle = lo + (high - lo) / 2;
        
        if (nums[middle] == target) {
            index = middle;
            return;
        }
        
        if (nums[middle] > target && nums[lo] < nums[high])
            helper(nums, target, lo, middle - 1);
        else if (nums[middle] < target && nums[lo] < nums[high])
            helper(nums, target, middle + 1, high);
        else {
            helper(nums, target, middle + 1, high);
            helper(nums, target, lo, middle - 1);
        }
    }
}
