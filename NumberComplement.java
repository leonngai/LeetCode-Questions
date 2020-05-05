class Solution {
    public int findComplement(int num) {
        int power = 0, sum = 0;
        
        while(num > 0) {
            if ((num & 1) == 0)
                sum += Math.pow(2, power);
            
            power++;
            num >>= 1;
        }
        
        return sum;
    }
}
