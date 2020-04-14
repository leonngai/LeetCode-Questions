class Solution {
    public int findMaxLength(int[] nums) {
        int balance = 0, len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                balance--;
            else
                balance++;
            
            if (!map.containsKey(balance))
                map.put(balance, i);
            else
                len = Math.max(len, i - map.get(balance));
        }
        
        return len;
    }
}
