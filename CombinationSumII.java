class Solution {
    /*
        Process
        1. Sort the array so that when we perform backtracking we will not have duplicate combinations
        2. Use recursive backtracking function to go through possible combinations
            2a. Have for loop inside recursive function that starts at our index up to the array length
            2b. Inside the for loop we compare if the current number at i and i - 1 are equal and if i > index because if so then we know that this will be a duplicate and we skip
            2c. Add the number to our list then call the recursive function before backtracking by removing the number from the list after the function call
    
    
    */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    public void backtrack(int[] candidates, int index, int target, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0)
            return;
 
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            temp.add(temp.size(), candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }
}
