class Solution {
    int[][] count;
    public void gameOfLife(int[][] board) {
        count = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++)
                helper(board, row, col);
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 1 && count[row][col] != 2 && count[row][col] != 3)
                    board[row][col] = 0;
                if (board[row][col] == 0 && count[row][col] == 3)
                    board[row][col] = 1;
            }
        }
    }
    
    public void helper(int[][] board, int row, int col) {
        //check right
        if (col + 1 < count[0].length && board[row][col + 1] == 1)
            count[row][col]++;
        //check down
        if (row + 1 < count.length && board[row + 1][col] == 1)
            count[row][col]++;
        //check left
        if (col - 1 >= 0 && board[row][col - 1] == 1)
            count[row][col]++;
        //check up 
        if (row - 1 >= 0 && board[row - 1][col] == 1)
            count[row][col]++;
        
        //check up right
        if (col + 1 < count[0].length && row - 1 >= 0 && board[row - 1][col + 1] == 1)
            count[row][col]++;
        //check bottom right
        if (col + 1 < count[0].length && row + 1 < count.length && board[row + 1][col + 1] == 1)
            count[row][col]++;
        //check bottom left
        if (col - 1 >= 0 && row + 1 < count.length && board[row + 1][col - 1] == 1)
            count[row][col]++;
        //check up left
        if (col - 1 >= 0 && row - 1 >= 0 && board[row - 1][col - 1] == 1)
            count[row][col]++;
    }
}
