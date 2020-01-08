class Solution {
    /*
        Things to do:
        1. Perform backtrack of numbers in nums array with temp list
            1a. Each time we are done with our backtrack, remove the number from our temp list
        2. Add the temp list into our resultant list of lists after each function call
        
        Space Complexity: O(N) worst case from our recursive stack call
    */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    public void backtrack(int[] nums, int index, List<Integer> list) {
        result.add(new ArrayList<>(list));
        
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
