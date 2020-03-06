class Solution {
    /*
        Process:
        1. Go through each cell and check if it is first a 1
        2. If it is a 1 then we take the min of the cells above, to the left and diagonal and add 1
            - By doing so we can keep track of the biggest "sub-square" that we have seen up until this point and use that result to calculate new results
        3. After updating the matrix at each cell location, we add that particular cells value to the result
        
        Time Complexity: O(M * N)
        Space Complexty: O(1)
    */
    public int countSquares(int[][] matrix) {
        int res = 0;
        
        //Use the input array to keep track of the result of previously looked at elements
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                //If the cell number is a 1 and it is not the first row and first column, take the result of the cell above it, the cell to the left and the cell diagonal to the upper left 
                if (matrix[r][c] == 1 && r != 0 && c != 0) {
                    matrix[r][c] = Math.min(matrix[r - 1][c - 1], Math.min(matrix[r - 1][c], matrix[r][c - 1])) + 1;
                }
                
                res += matrix[r][c];
            }
        }
        
        return res;
    }
}
