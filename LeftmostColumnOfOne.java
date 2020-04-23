/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
       x = row, y = col
 *     public List<Integer> dimensions {}
       dimensions[0] = row
       dimensions[1] = column
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int ans = -1;
        int row = 0, rowEnd = binaryMatrix.dimensions().get(0) - 1;
        int col = binaryMatrix.dimensions().get(1) - 1;
        
        while(row <= rowEnd && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                ans = col;
                col--;
            }
            else {
                row++;
            }
        }
        

        return ans;
    }
}
