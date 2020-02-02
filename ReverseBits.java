public class Solution {
    // you need treat n as an unsigned value
    // AND n with a 1 to get the right most bit
    // XOR the result with the right most bit (this will be 0 after a left bit shift)
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res ^= n & 1;
            n = n >>> 1;
        }
        
        return res;
    }
}
