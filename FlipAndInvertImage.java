class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        for (int row = 0; row < A.length; row++) {
            int start = 0, end = A[0].length - 1;
            while(start < end) {
                A[row][start] = A[row][start] == 0 ? 1 : 0;
                A[row][end] = A[row][end] == 0 ? 1 : 0;
                
                int temp = A[row][start];
                A[row][start] = A[row][end];
                A[row][end] = temp;
                
                start++;
                end--;
            }
            
            if (start == end)
                A[row][start] = A[row][start] == 0 ? 1 : 0;
        }
        
        return A;
    }
}
