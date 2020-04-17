class Solution {
    /*
        Process:
        - Keep track of the minimum possible balance and maximum possible balance of the string
        - Pretend to see each * that we see as a ( and add 1 to the maximum possible balance of the string
        - Pretend to see each * that we see as a ) and subtract 1 to the minimum possible balance of the string
        - If we at any point see the maximum possible balance reach less than 0 this means we have an invalid string because even treating all * as a ( was not enough to offset the )
        - If we at any point see the minimum possible balance reach less than 0 then we reset this back to 0 and pretend to use the * as a space because we cannot have a minimum balance of less than 0
    
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public boolean checkValidString(String s) {
        int minBal = 0, maxBal = 0;
        
        for (int i = 0; i < s.length(); i++) {
            minBal += s.charAt(i) == '(' ? 1 : -1;
            maxBal += s.charAt(i) != ')' ? 1 : -1;
            
            if (maxBal < 0)
                return false;
            
            minBal = Math.max(0, minBal);
        }
        
        return minBal == 0;
    }
}
