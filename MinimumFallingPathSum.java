class Solution {
    public int minFallingPathSum(int[][] A) {
        for (int row = 1; row < A.length; row++) {
            for (int col = 0; col < A.length; col++) {
                if (col == 0) 
                    A[row][col] += Math.min(A[row - 1][col], A[row - 1][col + 1]);
                else if (col == A.length - 1)
                    A[row][col] += Math.min(A[row - 1][col], A[row - 1][col - 1]);
                else 
                    A[row][col] += Math.min(A[row - 1][col], Math.min(A[row - 1][col - 1], A[row - 1][col + 1]));
            }
        }
        
        int min = A[A.length - 1][0];
        for (int col = 1; col < A.length; col++)
            min = Math.min(min, A[A.length - 1][col]);
        
        return min;
    }
}
