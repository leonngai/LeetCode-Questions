class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = left; i <=right; i++) {
            if (isSelfDividing(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public boolean isSelfDividing(int num) {
        int analyzedNumber = num;
        while (num > 0) {
            int divider = num % 10;
            if (divider == 0)
                return false;
            //means it is self dividing for that number
            if (analyzedNumber % divider != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
