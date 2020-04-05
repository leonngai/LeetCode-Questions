class Solution {
    public int singleNumber(int[] nums) {
        /*XOR table is as follows
            0 0 -> 0
            0 1 -> 1
            1 0 -> 1
            1 1 -> 0
            
            meaning that if we XOR two of the same numbers together we get 0, since we are guaranteed every number appears twice we can look at it is A XOR A XOR B which will turn into 0 XOR B eventually which equals B
        */
        
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        
        return res;
    }
}
