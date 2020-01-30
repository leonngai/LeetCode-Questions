public class Solution {
    // you need to treat n as an unsigned value
    
    /*
        Keep ANDing the most right bit with a 1 to see if it is a 1 or 0 and then add that to the answer
    */
    public int hammingWeight(int n) {
        int ans = 0;
        
        while(n != 0) {
            ans += n & 1;
            n = n >>> 1;
        }
        
        return ans;
    }
}
