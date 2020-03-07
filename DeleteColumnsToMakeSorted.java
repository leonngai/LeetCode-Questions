class Solution {
    /*
        Process:
        1. Go through each column and compare each row with the next to see if it is sorted
        2. As soon as we see that a column is unsorted, we break and go to the next column while adding 1 to our count
        
        Time Complexity: O(M * N)
        Space Complexity: O(1)
    
    */
    public int minDeletionSize(String[] A) {
        int ans = 0;
        
        for (int col = 0; col < A[0].length(); col++) {
            for (int row = 0; row < A.length - 1; row++) {
                if (A[row].charAt(col) > A[row + 1].charAt(col)) {
                    ans++;
                    break;
                }
            }
        }
        
        return ans;
    }
}
