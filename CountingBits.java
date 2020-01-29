class Solution {
    public int[] countBits(int num) {
        if (num <= 0)
            return new int[1];
        
        int power = 1, index = 1;
        int[] ans = new int[num + 1];
        
        while(index <= num) {
            if (index == power * 2)
                power *= 2;
            
            ans[index] = 1 + ans[index - power];            
            index++;
        }

        return ans;
    }
}
