class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      //count how many times the bits are nonequal on the right before right shifting
      int count = 0; 
      while(m != n){
        m >>= 1;
        n >>= 1;
        count++;  
      }  
      //return final answer left shifted count number of times
      return m << count;  
    }
    
    /*
    11010
    11011
    11100　　
    11101　　
    11110
    11010 -> 11
    11110 -> 11
    count = 3
    11000
    */
}
