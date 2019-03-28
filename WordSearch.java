class Solution {
    static boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if (board[0] == null || board == null || word == null)
            return false;
        
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == word.charAt(0)) {
                    result = helper(0, board, word, row, col);
                    if (result == true)
                        return result;
                }
            }
        }
        
        
        return result;
    }
    
    public boolean helper(int index, char [][] board, String word, int row, int col) {
        //means we matched all letters since we made it all the way to the word length
        if (index == word.length())
                return true;
        
        //base case of recursion method, make sure we are in bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(index) != board[row][col] || visited[row][col])
            return false;
        
        visited[row][col] = true;

        boolean resulttop = helper(index + 1, board, word, row - 1, col);
        boolean resultbottom = helper(index + 1, board, word, row + 1, col);
        boolean resultright = helper(index + 1, board, word, row, col + 1);
        boolean resultleft = helper(index + 1, board, word, row, col - 1);
            
        if (resulttop || resultbottom || resultright || resultleft)
            return true;
        
        //resets this to unvisited
        visited[row][col] = false;
        return false;

    }
}

//first instance we see with first char, we can recurse in all direcitons and pass the next char to it to find if it exists, add onto a stringbuilder

//compare stringbuilder to word and if at any point it is the same, return true
