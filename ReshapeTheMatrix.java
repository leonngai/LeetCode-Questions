class Solution {
    /*
        Process and things to remember:
            1. Check if num can even be reshaped into the given r and c or if r and c dimensions match num
                1a. If either of these conditions match, then return the original matrix
            2. Create new matrix of size r * c
            3. Iterate through original matrix to get values in row-traversing order
            4. When each value is grabbed, copy it to the new matrix using another row and column index to keep tack of where we are copying to on the new matrix
                4a. If we have run out of columns in the row of the new matrix, go to next row and reset column
            5. Return new matrix
            
        Time Complexity: O(R * C) number of elements we copy will always be R * C for worst case
        Space Complexity: O(1) constant time complexity as the space we use is not dependent on the input
    */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length || (r == nums.length && c == nums[0].length))
            return nums;
        
        int[][] newMatrix = new int[r][c];
        int newRowIndex = 0, newColIndex = 0;
        
        for (int oldRow = 0; oldRow < nums.length; oldRow++) {
            for (int oldCol = 0; oldCol < nums[0].length; oldCol++) {
                if (newColIndex == c) {
                    newRowIndex++;
                    newColIndex = 0;
                }
                
                newMatrix[newRowIndex][newColIndex] = nums[oldRow][oldCol];
                newColIndex++;
            }
        }
        
        return newMatrix;
    }
}
