class Solution {
    /*
        Thought process...
        All even numbers can shift to other even numbers with no cost
        All odd numbers can shift to other odd numbers with no cost
        So basically the only cost we have to be wary of is flipping from even to odd or odd to even
        The answer must be an odd number or even number and we have to find out if its "cheaper" to
        flip all odds to even or even to odds
        Hence... Count number of even numbers and odd numbers and return the smaller of the two
        
        Time Complexity: O(N)
        Space Complexity: O(1)
        
    */
    public int minCostToMoveChips(int[] chips) {
        int even = 0, odd = 0;
        
        for (int n : chips) {
            if (n % 2 == 0)
                even++;
            else    
                odd++;
        }
        
        return Math.min(even, odd);
    }
}
