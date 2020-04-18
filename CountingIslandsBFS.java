class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        Queue<Pair> q = new LinkedList<>();
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    
                    grid[row][col] = '0';
                    q.add(new Pair(row - 1, col));
                    q.add(new Pair(row + 1, col));
                    q.add(new Pair(row, col - 1));
                    q.add(new Pair(row, col + 1));
                    
                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        
                        if (p.row >= 0 && p.row < grid.length && p.col >= 0 && p.col < grid[0].length && grid[p.row][p.col] == '1') {
                            grid[p.row][p.col] = '0';
                            q.add(new Pair(p.row - 1, p.col));
                            q.add(new Pair(p.row + 1, p.col));
                            q.add(new Pair(p.row, p.col - 1));
                            q.add(new Pair(p.row, p.col + 1));
                        }
                    }
                }
            }
        }
        
        return islandCount;
    }             
}

class Pair {
    int row;
    int col;
    
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
