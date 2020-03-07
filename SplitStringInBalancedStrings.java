class Solution {
    /*
        Process:
        1. Take greedy approach and increment count as soon as we find a balanced substring
        2. Keep track of Rs and Ls seen where we increment count when R and decrement when L
        3. When count == 0, increment answer
        
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
    public int balancedStringSplit(String s) {
        int ans = 0, bal = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                bal++;
            else
                bal--;
            
            if (bal == 0)
                ans++;
        }
        
        return ans;
    }
}
