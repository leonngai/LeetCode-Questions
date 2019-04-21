class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList();
        
        if (matrix.length == 0) {
            return answer;
        }
        
        int leftbound = 0, upperbound = 0, rightbound = matrix[0].length, lowerbound = matrix.length;
        
        while(leftbound < rightbound && upperbound < lowerbound) {
            for (int col = leftbound; col < rightbound; col++) {
                answer.add(matrix[upperbound][col]);
            }
            
            upperbound++;
            
            for (int row = upperbound; row < lowerbound; row++) {
                answer.add(matrix[row][rightbound - 1]);
            }
            
            rightbound--;
            
            if (leftbound < rightbound && upperbound < lowerbound) {
            for (int col = rightbound; col > leftbound; col--) {
                answer.add(matrix[lowerbound - 1][col-1]);
            }
            
            lowerbound--;
            
            for (int row = lowerbound; row > upperbound; row--) {
                answer.add(matrix[row - 1][leftbound]);
            }
            leftbound++;
            }
        }
        
        
        
        return answer;
    }
}
