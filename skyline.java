class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
    	int sum = 0;
    	
        //first we need to find the tallest building in each row and column
        int[] highestRow = new int[grid.length];
        int[] highestCol = new int[grid[0].length];

        //iterate through each cell to do so
       
        for (int row = 0; row < grid.length; row++) {
        	for (int col = 0; col < grid[0].length; col++) {
        		int currentValue = grid[row][col];
        		highestRow[row] = Math.max(currentValue, highestRow[row]);
        		highestCol[col] = Math.max(currentValue,  highestCol[col]);
        	}
        }
        
        //now that we have the max for row and column we can subtract the minimum of the two with the original grid
        for (int row = 0; row < grid.length; row++) {
        	for (int col = 0; col < grid[0].length; col++) {
        		int currentValue = grid[row][col];
        		sum += Math.min(highestRow[row], highestCol[col]) - currentValue; 
        	}
        }
        
        return sum;
    }
}
