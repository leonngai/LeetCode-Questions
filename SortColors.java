class Solution {
    public void sortColors(int[] nums) {
        //One Pass solution
        int lowIndex = 0, highIndex = nums.length - 1;
        int position = 0;
        
        while(position <= highIndex) {
            if (nums[position] == 0) {
                int temp = nums[position];
                nums[position] = nums[lowIndex];
                nums[lowIndex] = temp;
                lowIndex++;
                position++;
            }
            else if (nums[position] == 2) {
                int temp = nums[position];
                nums[position] = nums[highIndex];
                nums[highIndex] = temp;
                highIndex--;
            }
            else {
                position++;
            }
        }
        
    }
    
    /* Two Pass solution
    int count0 = 0, count1 = 0, count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            else if (nums[i] == 1)
                count1++;
            else 
                count2++;
        }
        
        int index = 0;
        while(count0 > 0) {
            nums[index++] = 0;
            count0--;
        }
        
        while(count1 > 0) {
            nums[index++] = 1;
            count1--;
        }
        
        while(count2 > 0) {
            nums[index++] = 2;
            count2--;
        }
    
    */
}
