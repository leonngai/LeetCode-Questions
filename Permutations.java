class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, answer, new ArrayList<Integer>());
        
        return answer;
    }
    
    public void helper(int[] nums, List<List<Integer>> answer, List<Integer> perm) {
        if (perm.size() == nums.length) 
            answer.add(new ArrayList<Integer>(perm));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (perm.contains(nums[i])) 
                    continue;
                
                
                perm.add(nums[i]);
                helper(nums, answer, perm);
                perm.remove(perm.size() - 1);

            }
        }
        
       
    }
}
