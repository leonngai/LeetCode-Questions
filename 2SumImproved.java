class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int index = 0; index < nums.length; index++) {
            int wanted = target - nums[index];
            if (hash.containsKey(wanted)) {
                return new int[]{hash.get(wanted), index};
            }
            hash.put(nums[index], index);
        }
        
        return new int[]{-1, -1};
    }
}
