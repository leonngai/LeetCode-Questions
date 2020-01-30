class Solution {
    public int countSubstrings(String s) {
        int[][] grid = new int[s.length()][s.length()];
        int ans = s.length();
        
        for (int i = 0; i < grid.length; i++) {
            grid[i][i] = 1;
        }
        
        for (int row = grid.length - 2; row >= 0; row--) {
            for (int col = row + 1; col < grid.length; col++) {
                if (s.charAt(row) == s.charAt(col)) {
                    if (col - row == 1 || grid[row + 1][col - 1] == 1) {
                        ans++;
                        grid[row][col] = 1;
                    }
                }
            }
        }
        
        return ans;
    }
}
