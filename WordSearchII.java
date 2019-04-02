class Solution {
    static boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> hash = new HashSet<>();
        for (String x: words)
            hash.add(x);
        visited = new boolean[board.length][board[0].length];
        List<String> answer = new ArrayList<>();
        
        for (String x: hash) {
            outerloop:
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (recurse(board, row, col, x, 0)) {
                        answer.add(x);
                        break outerloop;
                    }
                }
            }

        }
        
        return answer;
        
    }
    
    public boolean recurse(char[][] board, int row, int col, String word, int index) {
        //base case
        if (index == word.length())
            return true;
        
        //check if in bounds or if it is the correct character
        if ( row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col] == true)
            return false;
        
        visited[row][col] = true;
        
        boolean recursetop = recurse(board, row - 1, col, word, index + 1);
        boolean recursebottom = recurse(board, row + 1, col, word, index + 1);
        boolean recurseright = recurse(board, row, col + 1, word, index + 1);
        boolean recurseleft = recurse(board, row, col - 1, word, index + 1);
        
        visited[row][col] = false;
        if (recursetop || recursebottom || recurseright || recurseleft)
            return true;
        
        visited[row][col] = false;
        return false;
    }
}

//look for first character of word, if found then pass that row and col number recursively

//recurse method needs:
/*
    - board, row, col, word at index, index number of word




*/
