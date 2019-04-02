class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum_Left = 0;
        int sum_Right = 0;
        
        for (int i = 0; i < nums.length; ++i)
        {
            if (i == 0)
            {sum_Left = 0;}
            else
            {sum_Left = sum_Left + nums[i-1];}
            
            for (int j = i+1; j < nums.length; ++j)
            {  
                sum_Right = sum_Right + nums[j];
            }
            
            if (sum_Right == sum_Left)
            {
                return i;
            }
            
            sum_Right = 0;
    }
        return -1;
}
}
