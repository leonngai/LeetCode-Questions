class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0))
                    if (helper(board, word, row, col, 0))
                        return true;
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false; 
        if (board[row][col] != word.charAt(index) || board[row][col] == ' ')
            return false;

        char temp = board[row][col];
        board[row][col] = ' ';
        
        boolean found = helper(board, word, row + 1, col, index + 1) || helper(board, word, row - 1, col, index + 1) || helper(board, word,row, col - 1, index + 1) || helper(board, word, row, col + 1, index + 1);
        
        board[row][col] = temp;
        return found;
    }
}

