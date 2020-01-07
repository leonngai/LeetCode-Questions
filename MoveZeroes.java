class Solution {
    public void moveZeroes(int[] nums) {
        int firstPointer = 0, secondPointer = 1;
        
        while(firstPointer < nums.length && secondPointer < nums.length) {
            if (nums[firstPointer] != 0) {
                firstPointer++;
                
                if(nums[secondPointer] != 0)
                    secondPointer++;
            }
            else {
                while(secondPointer < nums.length && nums[secondPointer] == 0) {
                    secondPointer++;
                }
                
                if(secondPointer < nums.length) {
                    nums[firstPointer] = nums[secondPointer];
                    nums[secondPointer] = 0;
                    firstPointer++;
                }
            }
        }
    }
}
