class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int index = 0; index < 9; index++) {
            if(!isValidHorizontally(board, index)) 
                return false;
            if (!isValidVertically(board, index))
                return false;          
        }
        
        for (int r = 0; r < 9; r = r + 3) {
            for (int c = 0; c < 9; c = c + 3) {
                if(!isValidSubBox(board, r, c))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean isValidSubBox(char[][] board, int row, int col) {
        int[] hash = new int[10];
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                char value = board[r][c];
                if (value != '.') {
                    int temp = value - '0';
                    if (hash[temp] > 0) {
                        return false;
                    }
                    hash[temp]++;
                }
            }
        }    
        
        return true;
    }
    
    public boolean isValidHorizontally(char[][] board, int row) {
        int[] hash = new int[10];
        for (int col = 0; col < 9; col++) {
            char value = board[row][col];
            if (value != '.') {
                int temp = value - '0';
                if (hash[temp] > 0) {
                    return false;
                }
                hash[temp]++;
            }
        }
        
        return true;
    }
    
    public boolean isValidVertically(char[][] board, int col) {
        int[] hash = new int[10];
        for (int row = 0; row < 9; row++) {
            char value = board[row][col];
            if (value != '.') {
                int temp = value - '0';
                if (hash[temp] > 0) {
                    return false;
                }
                hash[temp]++;
            }
        }
        
        return true;
    }
}
