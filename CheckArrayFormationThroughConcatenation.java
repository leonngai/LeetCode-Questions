class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        
        for (int[] piece: pieces) {
            if (piece.length == 1 && !map.containsKey(piece[0]))
                return false;
            else {
                Integer before = map.get(piece[0]);
                for (int i = 1; i < piece.length; i++) {
                    Integer after = map.get(piece[i]);
                    if (before == null || after == null || before + 1 != after)
                        return false;
                    
                    before = after;
                }
            }
        }
        
        return true;
    }
}
