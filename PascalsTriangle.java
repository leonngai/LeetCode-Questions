class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (row == col || col == 0)
                    list.add(1);
                else
                    list.add(lists.get(row - 1).get(col - 1) + lists.get(row - 1).get(col));    
            }
            lists.add(list);
        }
        return lists;
    }
