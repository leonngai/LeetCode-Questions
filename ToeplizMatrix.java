class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return false;
        
        for (int col = 0; col < matrix[0].length; col++) {
            int number = matrix[matrix.length - 1][col];
            int tempRow = matrix.length - 2, tempCol = col - 1;
            
            while(tempRow >= 0 && tempCol >= 0) {
                if (matrix[tempRow][tempCol] != number)
                    return false;
                
                tempRow--;
                tempCol--;
            }
        }
        
        for (int row = matrix.length - 2; row >= 0; row--) {
            int number = matrix[row][matrix[0].length - 1];
            int tempRow = row - 1, tempCol = matrix[0].length - 2;
            
            while(tempRow >= 0 && tempCol >= 0) {
                if (matrix[tempRow][tempCol] != number)
                    return false;
                
                tempRow--;
                tempCol--;
            }
        }
        
        return true;
    }
}
