class Solution {
    public boolean isHappy(int n) {
      
      Set<Integer> set = new HashSet<>();
      
      while(n != 1) {
        n = calculateNewSum(n);
        if (n == 1) {
          return true;
        }
        else if (set.contains(n)) {
          return false;
        }
        set.add(n);
      }
      
      return true;
    }
  
    public int calculateNewSum(int n) {
      int newSum = 0;
      
      while(n > 0) {
        newSum += Math.pow(n % 10, 2);
        n /= 10;
      }
      
      return newSum;
    }
}
