class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> oldlist = new ArrayList<>();
        
        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> newlist = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (row == col || col == 0) {
                    newlist.add(1);
                }
                else {
                    newlist.add(oldlist.get(col - 1) + oldlist.get(col));
                }
            }
            oldlist = newlist;
        }
        
        return oldlist;
    }
}
