class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                list.add(getNumber(row, col));
            }
            lists.add(list);
        }
        return lists;
    }
    
    public int getNumber(int row, int col) {
        if (row == col || col == 0)
            return 1;
        
        return getNumber(row - 1, col - 1) + getNumber(row - 1, col);
    }
    
}
