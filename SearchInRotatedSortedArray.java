class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int target, int start, int end) {
        if (end < start)
            return -1;
        
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        
        if (target >= nums[start] && target < nums[mid])
            return helper(nums, target, start, mid - 1);
        
        else if (target > nums[mid] && target <= nums[end])
            return helper(nums, target, mid + 1, end);
        
        else {
            int left = helper(nums, target, start, mid - 1);
            int right = helper(nums, target, mid + 1, end);
            if (left != -1)
                return left;
            
            if (right != -1)
                return right;
            
            return -1;
        }
    }
}
