ass Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        helper(list, candidates,target, new ArrayList<>(), 0);
        return list;
    }
    
    public  void helper(List<List<Integer>> list, int[] candidates, int target, List<Integer> temp, int start) {
        if (0 > target) 
            return;
        else if (0 == target)
            list.add(new LinkedList<>(temp));
        else {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                temp.add(candidates[i]);
                helper(list, candidates, target - candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
