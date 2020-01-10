class Solution {
    /*
        Process:
        1. Initialize boolean matrix to keep track of visited row and col
        2. Recursively visit the adjacent rows and columns of sr and sc
            2a. If the visited spot is not equal to the old colour OR it is out of bounds
            2b. If it is equal to the old colour, then recursively visit those adjacent rows and columns as well
        3. Return the modified matrix
    
        Time Complexity: O(R * C)
        Space Complexity: O(R) or O(C) depending on which one is bigger during the recursion stack
    */
    boolean[][] visited = null;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        
        replaceOldColor(image, sr, sc, oldColor, newColor);
        return image;
    }
    
    public void replaceOldColor(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || visited[row][col] == true || image[row][col] != oldColor)
            return;
        
        image[row][col] = newColor;
        visited[row][col] = true;
        replaceOldColor(image, row + 1, col, oldColor, newColor);
        replaceOldColor(image, row - 1, col, oldColor, newColor);
        replaceOldColor(image, row, col + 1, oldColor, newColor);
        replaceOldColor(image, row, col - 1, oldColor, newColor);
    }
}
