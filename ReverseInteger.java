class Solution {
    public int reverse(int x) {
       //need to account for negatives, as well as integer overflow
        // to account for negatives, first check when we enter function if negative, if it is then mark it down then turn to positive
        //to account for integer overflow, we want to check every loop that sum is equal to prev sum because if its not it means it overflowed and returned a garbage value
        int sum = 0, prevSum = 0;
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        
        while(x != 0) {
            sum = sum * 10 + x % 10;
            
            if ((sum - x % 10 ) / 10 != prevSum)
                return 0;
            
            x /= 10;
            prevSum = sum;
        }
        
        if (isNegative) 
            sum *= -1;
        
        return sum;
            
        
        
    }
}
