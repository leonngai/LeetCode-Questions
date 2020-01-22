class Solution {
    int ans = 0;
    public int findNumbers(int[] nums) {
        for (int n : nums)
            isEven(n);
        
        return ans;
    }
    
    public void isEven(int num) {
        int count = 0;
        
        while (num != 0) {
            count++;
            num /= 10;
        }
        
        if (count % 2 == 0)
            ans++;
    }
}
