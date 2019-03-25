class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] index = new int[2];
        
        outerloop:
        for (int i = 0; i < nums.length - 1; i++)
        {
            for ( int j = i + 1; j < nums.length; j++)
            {
                if (target == (nums[i] + nums[j]))
                {
                    index[0] = i;
                    index[1] = j;
                    break outerloop;
                }
                    
            }
        }
        return index;
    }
}
